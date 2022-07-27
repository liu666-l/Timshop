package com.goods.feign;

import com.goods.entity.Result;
import com.goods.pojo.Sku;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(value = "Skugoods")
@RequestMapping(value = "/sku")
public interface SkuFeign {
    @GetMapping("/import")
    public entity.Result importData();
    /**
     * 库存递减
     */
    @GetMapping(value = "/decr/count")
    public Result decrCount(@RequestParam Map<String,Integer> decrmap);
    /**
     * 查询所有的sku数据
     *
     * @return
     */
    @GetMapping
    Result<List<Sku>> findAll();
       /***
     * 多条件搜索品牌数据
     * @param sku
     * @return
     */
//    @PostMapping(value = "/search")
//    Result<List<Sku>> findList(@RequestBody(required = false) Sku sku);

    /**
     * 根据spu_id查询对应的sku集合
     * @param id
     * @return
     */
    @GetMapping("/spu/{id}")
    Result<List<Sku>> findBySpuId(@PathVariable Long id);

    /**
     * 根据spuid删除对应的sku
     * @param id
     * @return
     */
    @DeleteMapping("/deleteAll/{id}")
    Result deleteAllSkuBySpuId(@PathVariable Long id);

    /***
     * 根据ID查询Sku数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    //@ApiImplicitParam(name = "id",value = "skuId",required = true,paramType = "path",dataType = "String")
    //@PreAuthorize("hasAnyAuthority('user')")
     Result<Sku> findById(@PathVariable("id") String id);

    /**
     * 根据sku_id集合查询sku集合
     * @param skuIds
     * @return
     */
    @PostMapping("/list/ids")
    Result<List<Sku>> findBySkuIds(@Param("skuIds") List<Long> skuIds);

    /***
     * 修改Sku数据
     * @param sku
     * @param id
     * @return
     */
//    @PutMapping(value="/{id}")
//    public Result update(@RequestBody Sku sku,@PathVariable Long id);

    /**
     * 修改sku map集合
     * @param map
     * @return
     */
    @PutMapping(value="/update/map")
    Result updateMap(@RequestBody Map<Long,Sku> map);

}
