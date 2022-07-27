package com.user.service.impl;

import com.user.dao.SpuMapper;
import com.user.pojo.Spu;
import com.user.service.SpuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuMapper spuMapper;


    /**
     * Spu条件+分页查询
     * @param spu 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Spu> findPage(Spu spu, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(spu);
        //执行搜索
        return new PageInfo<Spu>(spuMapper.selectByExample(example));
    }

    /**
     * Spu分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Spu> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Spu>(spuMapper.selectAll());
    }

    /**
     * Spu条件查询
     * @param spu
     * @return
     */
    @Override
    public List<Spu> findList(Spu spu){
        //构建查询条件
        Example example = createExample(spu);
        //根据构建的条件查询数据
        return spuMapper.selectByExample(example);
    }


    /**
     * Spu构建查询对象
     * @param spu
     * @return
     */
    public Example createExample(Spu spu){
        Example example=new Example(Spu.class);
        Example.Criteria criteria = example.createCriteria();
        if(spu!=null){
            // 主键
            if(!StringUtils.isEmpty(spu.getId())){
                    criteria.andEqualTo("id",spu.getId());
            }
            // 货号
            if(!StringUtils.isEmpty(spu.getSn())){
                    criteria.andEqualTo("sn",spu.getSn());
            }
            // SPU名
            if(!StringUtils.isEmpty(spu.getName())){
                    criteria.andLike("name","%"+spu.getName()+"%");
            }
            // 副标题
            if(!StringUtils.isEmpty(spu.getCaption())){
                    criteria.andEqualTo("caption",spu.getCaption());
            }
            // 品牌ID
            if(!StringUtils.isEmpty(spu.getBrandBrandId())){
                    criteria.andEqualTo("brandBrandId",spu.getBrandBrandId());
            }
            // 一级分类
            if(!StringUtils.isEmpty(spu.getCategory1Category1Id())){
                    criteria.andEqualTo("category1Category1Id",spu.getCategory1Category1Id());
            }
            // 二级分类
            if(!StringUtils.isEmpty(spu.getCategory2Category2Id())){
                    criteria.andEqualTo("category2Category2Id",spu.getCategory2Category2Id());
            }
            // 三级分类
            if(!StringUtils.isEmpty(spu.getCategory3Category3Id())){
                    criteria.andEqualTo("category3Category3Id",spu.getCategory3Category3Id());
            }
            // 模板ID
            if(!StringUtils.isEmpty(spu.getTemplateTemplateId())){
                    criteria.andEqualTo("templateTemplateId",spu.getTemplateTemplateId());
            }
            // 运费模板id
            if(!StringUtils.isEmpty(spu.getFreightFreightId())){
                    criteria.andEqualTo("freightFreightId",spu.getFreightFreightId());
            }
            // 图片
            if(!StringUtils.isEmpty(spu.getImage())){
                    criteria.andEqualTo("image",spu.getImage());
            }
            // 图片列表
            if(!StringUtils.isEmpty(spu.getImages())){
                    criteria.andEqualTo("images",spu.getImages());
            }
            // 售后服务
            if(!StringUtils.isEmpty(spu.getSaleSaleService())){
                    criteria.andEqualTo("saleSaleService",spu.getSaleSaleService());
            }
            // 介绍
            if(!StringUtils.isEmpty(spu.getIntroduction())){
                    criteria.andEqualTo("introduction",spu.getIntroduction());
            }
            // 规格列表
            if(!StringUtils.isEmpty(spu.getSpecSpecItems())){
                    criteria.andEqualTo("specSpecItems",spu.getSpecSpecItems());
            }
            // 参数列表
            if(!StringUtils.isEmpty(spu.getParaParaItems())){
                    criteria.andEqualTo("paraParaItems",spu.getParaParaItems());
            }
            // 销量
            if(!StringUtils.isEmpty(spu.getSaleSaleNum())){
                    criteria.andEqualTo("saleSaleNum",spu.getSaleSaleNum());
            }
            // 评论数
            if(!StringUtils.isEmpty(spu.getCommentCommentNum())){
                    criteria.andEqualTo("commentCommentNum",spu.getCommentCommentNum());
            }
            // 是否上架
            if(!StringUtils.isEmpty(spu.getIsIsMarketable())){
                    criteria.andEqualTo("isIsMarketable",spu.getIsIsMarketable());
            }
            // 是否启用规格
            if(!StringUtils.isEmpty(spu.getIsIsEnableSpec())){
                    criteria.andEqualTo("isIsEnableSpec",spu.getIsIsEnableSpec());
            }
            // 是否删除
            if(!StringUtils.isEmpty(spu.getIsIsDelete())){
                    criteria.andEqualTo("isIsDelete",spu.getIsIsDelete());
            }
            // 审核状态
            if(!StringUtils.isEmpty(spu.getStatus())){
                    criteria.andEqualTo("status",spu.getStatus());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Long id){
        spuMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Spu
     * @param spu
     */
    @Override
    public void update(Spu spu){
        spuMapper.updateByPrimaryKey(spu);
    }

    /**
     * 增加Spu
     * @param spu
     */
    @Override
    public void add(Spu spu){
        spuMapper.insert(spu);
    }

    /**
     * 根据ID查询Spu
     * @param id
     * @return
     */
    @Override
    public Spu findById(Long id){
        return  spuMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Spu全部数据
     * @return
     */
    @Override
    public List<Spu> findAll() {
        return spuMapper.selectAll();
    }
}
