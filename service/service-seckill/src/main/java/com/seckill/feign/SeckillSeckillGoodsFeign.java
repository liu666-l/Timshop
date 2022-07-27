package com.seckill.feign;

import com.github.pagehelper.PageInfo;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import pojo.SeckillSeckillGoods;

import java.util.List;


@FeignClient(name="seckill ")
@RequestMapping("/seckillSeckillGoods")
public interface SeckillSeckillGoodsFeign {

    /***
     * SeckillSeckillGoods分页条件搜索实现
     * @param seckillSeckillGoods
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SeckillSeckillGoods seckillSeckillGoods, @PathVariable int page, @PathVariable  int size);

    /***
     * SeckillSeckillGoods分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param seckillSeckillGoods
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SeckillSeckillGoods>> findList(@RequestBody(required = false) SeckillSeckillGoods seckillSeckillGoods);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改SeckillSeckillGoods数据
     * @param seckillSeckillGoods
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SeckillSeckillGoods seckillSeckillGoods,@PathVariable Long id);

    /***
     * 新增SeckillSeckillGoods数据
     * @param seckillSeckillGoods
     * @return
     */
    @PostMapping
    Result add(@RequestBody SeckillSeckillGoods seckillSeckillGoods);

    /***
     * 根据ID查询SeckillSeckillGoods数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SeckillSeckillGoods> findById(@PathVariable Long id);

    /***
     * 查询SeckillSeckillGoods全部数据
     * @return
     */
    @GetMapping
    Result<List<SeckillSeckillGoods>> findAll();
}