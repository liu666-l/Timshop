package com.seckill.controller;

import com.seckill.service.SeckillSeckillOrderService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.SeckillStatus;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.SeckillSeckillOrder;

import java.util.List;


@RestController
@RequestMapping("/seckillSeckillOrder")
@CrossOrigin
public class SeckillSeckillOrderController {

    @Autowired
    private SeckillSeckillOrderService seckillSeckillOrderService;
    /**
     * 抢单状态查询
     */
    @GetMapping(value = "/query")
    public Result queryStatus(){
        String username="liuxiaoyong";
        SeckillStatus status = seckillSeckillOrderService.queryStatus(username);
        if(status!=null){
          return   new Result<>(true,StatusCode.OK,"查询成功",status);
        }
        return new Result(false,StatusCode.NOTFOUNDERROR,"抢单失败");
    }

    /**
     * @param time
     * @param id
     * @return
     */
    @RequestMapping(value = "/add")
    public Result add(String time,Long id){
        String username="liuxiaoyong";
        seckillSeckillOrderService.add(time,id,username);
        return new Result(true,StatusCode.OK,"排队中....");
    }

    /***
     * SeckillSeckillOrder分页条件搜索实现
     * @param seckillSeckillOrder
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  SeckillSeckillOrder seckillSeckillOrder, @PathVariable  int page, @PathVariable  int size){
        //调用SeckillSeckillOrderService实现分页条件查询SeckillSeckillOrder
        PageInfo<SeckillSeckillOrder> pageInfo = seckillSeckillOrderService.findPage(seckillSeckillOrder, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SeckillSeckillOrder分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SeckillSeckillOrderService实现分页查询SeckillSeckillOrder
        PageInfo<SeckillSeckillOrder> pageInfo = seckillSeckillOrderService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param seckillSeckillOrder
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<SeckillSeckillOrder>> findList(@RequestBody(required = false)  SeckillSeckillOrder seckillSeckillOrder){
        //调用SeckillSeckillOrderService实现条件查询SeckillSeckillOrder
        List<SeckillSeckillOrder> list = seckillSeckillOrderService.findList(seckillSeckillOrder);
        return new Result<List<SeckillSeckillOrder>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用SeckillSeckillOrderService实现根据主键删除
        seckillSeckillOrderService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SeckillSeckillOrder数据
     * @param seckillSeckillOrder
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SeckillSeckillOrder seckillSeckillOrder,@PathVariable Long id){
        //设置主键值
        seckillSeckillOrder.setId(id);
        //调用SeckillSeckillOrderService实现修改SeckillSeckillOrder
        seckillSeckillOrderService.update(seckillSeckillOrder);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SeckillSeckillOrder数据
     * @param seckillSeckillOrder
     * @return
     */


    /***
     * 根据ID查询SeckillSeckillOrder数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<SeckillSeckillOrder> findById(@PathVariable Long id){
        //调用SeckillSeckillOrderService实现根据主键查询SeckillSeckillOrder
        SeckillSeckillOrder seckillSeckillOrder = seckillSeckillOrderService.findById(id);
        return new Result<SeckillSeckillOrder>(true,StatusCode.OK,"查询成功",seckillSeckillOrder);
    }

    /***
     * 查询SeckillSeckillOrder全部数据
     * @return
     */
    @GetMapping
    public Result<List<SeckillSeckillOrder>> findAll(){
        //调用SeckillSeckillOrderService实现查询所有SeckillSeckillOrder
        List<SeckillSeckillOrder> list = seckillSeckillOrderService.findAll();
        return new Result<List<SeckillSeckillOrder>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
