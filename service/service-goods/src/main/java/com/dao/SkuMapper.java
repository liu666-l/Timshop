package com.dao;

import com.goods.pojo.Sku;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:lxy
 * @Description:Sku的Dao
 *****/
@Repository("skuMapper")
public interface SkuMapper extends Mapper<Sku> {

    /**
     * 根据spu_id查找Sku
     * @param spuId
     * @return
     */
    @Select("select * from tb_sku where spu_id=#{spuId}")
    public List<Sku> findBySpuId(long spuId);

    /**
     * 根据spuid删除对应的sku
     * @param id
     * @return
     */
    @Delete("delete * from tb_sku where spu_id=#{spuId}")
    void deleteAllSkuBySpuId(Long id);

    /**
     * 根据sku_id集合查询sku集合
     * @param skuIds
     * @return
     */
    @Select("select * from tb_sku where id in (${skuIds})")
    List<Sku> findBySkuIds(@Param("skuIds") String skuIds);
    @Select("select * from tb_sku where id=#{id}")
    Sku findById(@Param("id")String id);

    /**
     * 库存递减
     * @param id
     * @param num
     * @return
     */
    @Update("update tb_sku set num=#{num} where id=#{id} and num>=#{num}")
    int decrmap(@Param("id") Long id,@Param("num") Integer num);
}
