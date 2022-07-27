package com.order.controller;

import com.order.pojo.ReturnReturnOrderItem;
import com.order.service.ReturnReturnOrderItemService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/returnReturnOrderItem")
@CrossOrigin
public class ReturnReturnOrderItemController {

    @Autowired
    private ReturnReturnOrderItemService returnReturnOrderItemService;

    /***
     * ReturnReturnOrderItem分页条件搜索实现
     * @param returnReturnOrderItem
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  ReturnReturnOrderItem returnReturnOrderItem, @PathVariable  int page, @PathVariable  int size){
        //调用ReturnReturnOrderItemService实现分页条件查询ReturnReturnOrderItem
        PageInfo<ReturnReturnOrderItem> pageInfo = returnReturnOrderItemService.findPage(returnReturnOrderItem, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * ReturnReturnOrderItem分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ReturnReturnOrderItemService实现分页查询ReturnReturnOrderItem
        PageInfo<ReturnReturnOrderItem> pageInfo = returnReturnOrderItemService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param returnReturnOrderItem
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<ReturnReturnOrderItem>> findList(@RequestBody(required = false)  ReturnReturnOrderItem returnReturnOrderItem){
        //调用ReturnReturnOrderItemService实现条件查询ReturnReturnOrderItem
        List<ReturnReturnOrderItem> list = returnReturnOrderItemService.findList(returnReturnOrderItem);
        return new Result<List<ReturnReturnOrderItem>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用ReturnReturnOrderItemService实现根据主键删除
        returnReturnOrderItemService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改ReturnReturnOrderItem数据
     * @param returnReturnOrderItem
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  ReturnReturnOrderItem returnReturnOrderItem,@PathVariable String id){
        //设置主键值
        returnReturnOrderItem.setId(id);
        //调用ReturnReturnOrderItemService实现修改ReturnReturnOrderItem
        returnReturnOrderItemService.update(returnReturnOrderItem);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增ReturnReturnOrderItem数据
     * @param returnReturnOrderItem
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   ReturnReturnOrderItem returnReturnOrderItem){
        //调用ReturnReturnOrderItemService实现添加ReturnReturnOrderItem
        returnReturnOrderItemService.add(returnReturnOrderItem);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询ReturnReturnOrderItem数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<ReturnReturnOrderItem> findById(@PathVariable String id){
        //调用ReturnReturnOrderItemService实现根据主键查询ReturnReturnOrderItem
        ReturnReturnOrderItem returnReturnOrderItem = returnReturnOrderItemService.findById(id);
        return new Result<ReturnReturnOrderItem>(true,StatusCode.OK,"查询成功",returnReturnOrderItem);
    }

    /***
     * 查询ReturnReturnOrderItem全部数据
     * @return
     */
    @GetMapping
    public Result<List<ReturnReturnOrderItem>> findAll(){
        //调用ReturnReturnOrderItemService实现查询所有ReturnReturnOrderItem
        List<ReturnReturnOrderItem> list = returnReturnOrderItemService.findAll();
        return new Result<List<ReturnReturnOrderItem>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
