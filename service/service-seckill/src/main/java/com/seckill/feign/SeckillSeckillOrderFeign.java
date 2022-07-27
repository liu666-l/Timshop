package com.seckill.feign;

import com.github.pagehelper.PageInfo;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import pojo.SeckillSeckillOrder;

import java.util.List;


@FeignClient(name="seckill ")
@RequestMapping("/seckillSeckillOrder")
public interface SeckillSeckillOrderFeign {

    /***
     * SeckillSeckillOrder分页条件搜索实现
     * @param seckillSeckillOrder
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SeckillSeckillOrder seckillSeckillOrder, @PathVariable int page, @PathVariable  int size);

    /***
     * SeckillSeckillOrder分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param seckillSeckillOrder
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SeckillSeckillOrder>> findList(@RequestBody(required = false) SeckillSeckillOrder seckillSeckillOrder);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改SeckillSeckillOrder数据
     * @param seckillSeckillOrder
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SeckillSeckillOrder seckillSeckillOrder,@PathVariable Long id);

    /***
     * 新增SeckillSeckillOrder数据
     * @param seckillSeckillOrder
     * @return
     */
    @PostMapping
    Result add(@RequestBody SeckillSeckillOrder seckillSeckillOrder);

    /***
     * 根据ID查询SeckillSeckillOrder数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SeckillSeckillOrder> findById(@PathVariable Long id);

    /***
     * 查询SeckillSeckillOrder全部数据
     * @return
     */
    @GetMapping
    Result<List<SeckillSeckillOrder>> findAll();
}