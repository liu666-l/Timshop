package com.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.goods.feign.SkuFeign;
import com.goods.pojo.Sku;
import com.search.dao.SkuesMapper;
import com.search.pojo.SkuInfo;
import com.search.service.SkuService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    private SkuFeign skuFeign;
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private SkuesMapper skuesMapper;
    @Override
    public Map<String, Object> search(Map<String, String> stringMap) {
        NativeSearchQueryBuilder builder = buildBasicQuery(stringMap);
        Map<String,Object> resultMap = searchList(builder);
        //分类查询实现
        if(stringMap==null||StringUtils.isEmpty(stringMap.get("category"))){
            List<String> list = searchCategoryList(builder);
            resultMap.put("categoryList",list);
        }
        //品牌分类查询实现
        if(stringMap==null||StringUtils.isEmpty(stringMap.get("brand"))){
            List<String> list1 = searchBrandList(builder);
            resultMap.put("brandName",list1);
        }
        //规格查询
        Map<String,Set<String>> specList = searchSpecList(builder);
        resultMap.put("specList",specList);
        return resultMap;

    }

    private NativeSearchQueryBuilder buildBasicQuery(Map<String, String> stringMap) {
        NativeSearchQueryBuilder builder=new NativeSearchQueryBuilder();//搜索条件构建对象，用于封装各种条件；
        BoolQueryBuilder boolQueryBuilder=QueryBuilders.boolQuery();
        if(stringMap !=null&& stringMap.size()>0){
            String key= stringMap.get("keyword");
            if(!StringUtils.isEmpty(key)){
               // builder.withQuery(QueryBuilders.queryStringQuery(key).field("name"));
                boolQueryBuilder.must(QueryBuilders.queryStringQuery(key).field("name"));
            }
            if(!StringUtils.isEmpty(stringMap.get("category"))){
                // builder.withQuery(QueryBuilders.queryStringQuery(key).field("name"));
                boolQueryBuilder.must(QueryBuilders.termQuery("categoryName",stringMap.get("category")));
            }
            if(!StringUtils.isEmpty(stringMap.get("brand"))){
                // builder.withQuery(QueryBuilders.queryStringQuery(key).field("name"));
                boolQueryBuilder.must(QueryBuilders.termQuery("brandName",stringMap.get("brand")));
            }
            //规格筛选
            for(Map.Entry<String,String> entry :stringMap.entrySet()){
                String key1= entry.getKey();
                if(key1.startsWith("spec_")){
                    //规格条件的值
                    String value= entry.getValue();
                    //spec_网络
                    boolQueryBuilder.must(QueryBuilders.termQuery("specMap."+key1.substring(5)+".keyword",value));
                }
            }
            //价格区间//price 0-500元 500-100元
            String price=stringMap.get("price");
            if (!StringUtils.isEmpty(price)) {    //价格过滤
              String[] prices = price.replace("元", "")
                        .replace("以上", "").split("-");
                boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").gte(Integer.parseInt(prices[0])));
                if (prices.length > 1) {
                    boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").lt(Integer.parseInt(prices[1])));
                }
            }
            //分页
            Integer pagenum=converPage(stringMap);
            Integer size=10;
            builder.withPageable(PageRequest.of(pagenum-1,size));
           //排序实现
            String sortField=stringMap.get("sortField");//指定排序的域
            String sortRule=stringMap.get("sortRule");//指定排序的规则
            if(!StringUtils.isEmpty(sortField)&&!StringUtils.isEmpty(sortRule)){
                builder.withSort(
                        new FieldSortBuilder(sortField)
                                .order(SortOrder.valueOf(sortRule))
                );
            }
        }
        builder.withQuery(boolQueryBuilder);
        return builder;
    }

    /**
     * 接收前端传入的分页参数
     * @param searchMap
     * @return
     */
    public Integer converPage(Map<String, String> searchMap){
        if(searchMap!=null){
            String pageNum=searchMap.get("pageNum");
            try {
                return Integer.parseInt(pageNum);
            }catch (NumberFormatException e){
                return 1;
            }
        }
        return 1;

    }

    private Map<String, Object> searchList(NativeSearchQueryBuilder builder) {
        //高亮配置
        HighlightBuilder.Field field=new HighlightBuilder.Field("name");
        field.preTags("<em style=\"color:red;\"");//前缀
        field.postTags("</em>");//后缀
        field.fragmentSize(100);//碎片长度
        builder.withHighlightFields(field);

        AggregatedPage<SkuInfo> page = elasticsearchTemplate
                .queryForPage(
                        builder.build(), //搜索条件封装
                        SkuInfo.class, //数据集合要转换的类型
                        new SearchResultMapper() {
                            @Override
                            public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                                //存储高亮数据
                                List<T> listgl=new ArrayList<T>();
                                //执行查询
                                for(SearchHit hit: searchResponse.getHits()){
                                    //分析结果数据，获取非高亮的数据
                                    SkuInfo skuInfo=JSON.parseObject(hit.getSourceAsString(),SkuInfo.class);
                                    //获取高亮数据
                                    HighlightField highlightField=hit.getHighlightFields().get("name");
                                    if(highlightField!=null&&highlightField.getFragments()!=null){
                                        //获取高亮的数据
                                        Text[] fragments=highlightField.getFragments();
                                        StringBuilder buffer=new StringBuilder();
                                        for(Text fragment: fragments){
                                            buffer.append(fragment.toString());
                                        }
                                        // 非高亮的数据替换成高亮数据
                                        skuInfo.setName(buffer.toString());
                                    }
                                    listgl.add((T)skuInfo);
                                }
                                /**
                                 * 1搜索集合数据：listgl
                                 * 2分页对象：pageale;
                                 * 3 搜索记录总条数：long total
                                 */

                                return new AggregatedPageImpl<T>(listgl,pageable,searchResponse.getHits().getTotalHits());
                            }
                        }

                );
        //获取分页封装信息
        /**
         * 分组查询分类集合
         */
        //分页参数
        long totalElements = page.getTotalElements();
        //总页数
        int totalPages = page.getTotalPages();
        //获取数据结果集
        List<SkuInfo> content = page.getContent();
        Map<String,Object> resultMap=new HashMap<String,Object>();
        resultMap.put("rows",content);
        resultMap.put("total",totalElements);
        resultMap.put("totalPages",totalPages);
             return resultMap;
    }

    /**
     * 分类分组查询
     * @param builder
     * @return
     */
    private List<String> searchCategoryList(NativeSearchQueryBuilder builder) {
        builder.addAggregation(AggregationBuilders.terms("skuCategory").field("categoryName"));
        AggregatedPage<SkuInfo> aggregatedPage=elasticsearchTemplate.queryForPage(builder.build(),SkuInfo.class);
        /**
         * 获取分组数据
         * aggreagatePage.getAggreations():获取的集合是，可以给拒多个域进行分组
         * 。get("skuCategory"):获取指定的集合域【手机，家用电器，手机配件】
         */
        StringTerms stringTerms=aggregatedPage.getAggregations().get("skuCategory");
        List<String> list=new ArrayList<String>();
        for(StringTerms.Bucket bucket:stringTerms.getBuckets()){
            String categoryName=bucket.getKeyAsString();
            list.add(categoryName);
        }
        return list;
    }

    /**
     * 品牌分组查询
     */
    private List<String> searchBrandList(NativeSearchQueryBuilder builder) {
        /**
         * 获取分组数据
         * aggreagatePage.getAggreations():获取的集合是，可以给拒多个域进行分组
         * 。get("skubrand"):获取指定的集合域【小米，华为，TCL】
         */
        builder.addAggregation(AggregationBuilders.terms("skuBrand").field("brandName"));
        AggregatedPage<SkuInfo> aggregatedPage=elasticsearchTemplate.queryForPage(builder.build(),SkuInfo.class);

        StringTerms stringTerms=aggregatedPage.getAggregations().get("skuBrand");
        List<String> list1=new ArrayList<String>();
        for(StringTerms.Bucket bucket:stringTerms.getBuckets()){
            String brandName=bucket.getKeyAsString();
            list1.add(brandName);
        }
        return list1;
    }

    /**
     * 规格分组查询
     * @param builder
     * @return
     */
    private Map<String,Set<String>> searchSpecList(NativeSearchQueryBuilder builder) {
        /**
         * 获取分组数据
         * aggreagatePage.getAggreations():获取的集合是，可以给拒多个域进行分组
         * 。get("skubrand"):获取指定的集合域【小米，华为，TCL】
         */
        builder.addAggregation(AggregationBuilders.terms("skuSpec").field("spec.keyword"));
        AggregatedPage<SkuInfo> aggregatedPage=elasticsearchTemplate.queryForPage(builder.build(),SkuInfo.class);

        StringTerms stringTerms=aggregatedPage.getAggregations().get("skuSpec");
        List<String> specList=new ArrayList<String>();
        Map<String, Set<String>> allSpec=new HashMap<String ,Set<String>>();

        for(StringTerms.Bucket bucket:stringTerms.getBuckets()){
            String specName=bucket.getKeyAsString();
            specList.add(specName);
            //合并后的Map对象
                       //1/循环speclist
            for (String spec: specList){
                Map<String,String> specMap = JSON.parseObject(spec, Map.class);
                for (Map.Entry<String,String> entry:specMap.entrySet()){
                    //取出当前Map
                    String key= entry.getKey();
                    String value= entry.getValue();

                    Set<String> specSet=allSpec.get(key);
                    if (specSet==null){
                        specSet=new HashSet<String>();
                    }
                    specSet.add(value);
                    allSpec.put(key,specSet);
                }
            }
            //2将每个JSON字符串转换成Map
            //将每个MAp对象合成一个Map<String,Set<String>>
            //循环当前Map,获取对应的KEY,以及对应的value

        }
       // return list1;
        return allSpec;
    }


    @Override
    public void importData() {
        List<Sku> skuResult= skuFeign.findAll().getData();
        List<SkuInfo> skuInfoList= JSON.parseArray(JSON.toJSONString(skuResult),SkuInfo.class).subList(0,1000);
        for(SkuInfo skuInfo:skuInfoList){
            Map<String,Object> map=JSON.parseObject(skuInfo.getSpec(),Map.class);
            skuInfo.setSpecMap(map);
        }
        skuesMapper.saveAll(skuInfoList);
    }
}
