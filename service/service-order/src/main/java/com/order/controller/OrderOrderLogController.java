package com.order.controller;

import com.order.pojo.OrderOrderLog;
import com.order.service.OrderOrderLogService;
import com.github.pagehelper.PageInfo;
import com.order.pojo.OrderOrderLog;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orderOrderLog")
@CrossOrigin
public class OrderOrderLogController {

    @Autowired
    private OrderOrderLogService orderOrderLogService;

    /***
     * OrderOrderLog分页条件搜索实现
     * @param orderOrderLog
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) OrderOrderLog orderOrderLog, @PathVariable  int page, @PathVariable  int size){
        //调用OrderOrderLogService实现分页条件查询OrderOrderLog
        PageInfo<OrderOrderLog> pageInfo = orderOrderLogService.findPage(orderOrderLog, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * OrderOrderLog分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OrderOrderLogService实现分页查询OrderOrderLog
        PageInfo<OrderOrderLog> pageInfo = orderOrderLogService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param orderOrderLog
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<OrderOrderLog>> findList(@RequestBody(required = false)  OrderOrderLog orderOrderLog){
        //调用OrderOrderLogService实现条件查询OrderOrderLog
        List<OrderOrderLog> list = orderOrderLogService.findList(orderOrderLog);
        return new Result<List<OrderOrderLog>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用OrderOrderLogService实现根据主键删除
        orderOrderLogService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改OrderOrderLog数据
     * @param orderOrderLog
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  OrderOrderLog orderOrderLog,@PathVariable String id){
        //设置主键值
        orderOrderLog.setId(id);
        //调用OrderOrderLogService实现修改OrderOrderLog
        orderOrderLogService.update(orderOrderLog);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增OrderOrderLog数据
     * @param orderOrderLog
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   OrderOrderLog orderOrderLog){
        //调用OrderOrderLogService实现添加OrderOrderLog
        orderOrderLogService.add(orderOrderLog);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询OrderOrderLog数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<OrderOrderLog> findById(@PathVariable String id){
        //调用OrderOrderLogService实现根据主键查询OrderOrderLog
        OrderOrderLog orderOrderLog = orderOrderLogService.findById(id);
        return new Result<OrderOrderLog>(true,StatusCode.OK,"查询成功",orderOrderLog);
    }

    /***
     * 查询OrderOrderLog全部数据
     * @return
     */
    @GetMapping
    public Result<List<OrderOrderLog>> findAll(){
        //调用OrderOrderLogService实现查询所有OrderOrderLog
        List<OrderOrderLog> list = orderOrderLogService.findAll();
        return new Result<List<OrderOrderLog>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
