package com.order.controller;

import com.order.pojo.OrderItem;
import com.order.service.OrderOrderItemService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orderOrderItem")
@CrossOrigin
public class OrderOrderItemController {

    @Autowired
    private OrderOrderItemService orderOrderItemService;

    /***
     * OrderOrderItem分页条件搜索实现
     * @param orderItem
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) OrderItem orderItem, @PathVariable  int page, @PathVariable  int size){
        //调用OrderOrderItemService实现分页条件查询OrderOrderItem
        PageInfo<OrderItem> pageInfo = orderOrderItemService.findPage(orderItem, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * OrderOrderItem分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OrderOrderItemService实现分页查询OrderOrderItem
        PageInfo<OrderItem> pageInfo = orderOrderItemService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param orderItem
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<OrderItem>> findList(@RequestBody(required = false) OrderItem orderItem){
        //调用OrderOrderItemService实现条件查询OrderOrderItem
        List<OrderItem> list = orderOrderItemService.findList(orderItem);
        return new Result<List<OrderItem>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用OrderOrderItemService实现根据主键删除
        orderOrderItemService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改OrderOrderItem数据
     * @param orderItem
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody OrderItem orderItem, @PathVariable String id){
        //设置主键值
        orderItem.setId(id);
        //调用OrderOrderItemService实现修改OrderOrderItem
        orderOrderItemService.update(orderItem);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增OrderOrderItem数据
     * @param orderItem
     * @return
     */
    @PostMapping
    public Result add(@RequestBody OrderItem orderItem){
        //调用OrderOrderItemService实现添加OrderOrderItem
        orderOrderItemService.add(orderItem);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询OrderOrderItem数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<OrderItem> findById(@PathVariable String id){
        //调用OrderOrderItemService实现根据主键查询OrderOrderItem
        OrderItem orderItem = orderOrderItemService.findById(id);
        return new Result<OrderItem>(true,StatusCode.OK,"查询成功", orderItem);
    }

    /***
     * 查询OrderOrderItem全部数据
     * @return
     */
    @GetMapping
    public Result<List<OrderItem>> findAll(){
        //调用OrderOrderItemService实现查询所有OrderOrderItem
        List<OrderItem> list = orderOrderItemService.findAll();
        return new Result<List<OrderItem>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
