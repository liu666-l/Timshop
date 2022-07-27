package com.order.controller;

import com.order.pojo.ReturnReturnOrder;
import com.order.service.ReturnReturnOrderService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/returnReturnOrder")
@CrossOrigin
public class ReturnReturnOrderController {

    @Autowired
    private ReturnReturnOrderService returnReturnOrderService;

    /***
     * ReturnReturnOrder分页条件搜索实现
     * @param returnReturnOrder
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  ReturnReturnOrder returnReturnOrder, @PathVariable  int page, @PathVariable  int size){
        //调用ReturnReturnOrderService实现分页条件查询ReturnReturnOrder
        PageInfo<ReturnReturnOrder> pageInfo = returnReturnOrderService.findPage(returnReturnOrder, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * ReturnReturnOrder分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ReturnReturnOrderService实现分页查询ReturnReturnOrder
        PageInfo<ReturnReturnOrder> pageInfo = returnReturnOrderService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param returnReturnOrder
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<ReturnReturnOrder>> findList(@RequestBody(required = false)  ReturnReturnOrder returnReturnOrder){
        //调用ReturnReturnOrderService实现条件查询ReturnReturnOrder
        List<ReturnReturnOrder> list = returnReturnOrderService.findList(returnReturnOrder);
        return new Result<List<ReturnReturnOrder>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用ReturnReturnOrderService实现根据主键删除
        returnReturnOrderService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改ReturnReturnOrder数据
     * @param returnReturnOrder
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  ReturnReturnOrder returnReturnOrder,@PathVariable String id){
        //设置主键值
        returnReturnOrder.setId(id);
        //调用ReturnReturnOrderService实现修改ReturnReturnOrder
        returnReturnOrderService.update(returnReturnOrder);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增ReturnReturnOrder数据
     * @param returnReturnOrder
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   ReturnReturnOrder returnReturnOrder){
        //调用ReturnReturnOrderService实现添加ReturnReturnOrder
        returnReturnOrderService.add(returnReturnOrder);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询ReturnReturnOrder数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<ReturnReturnOrder> findById(@PathVariable String id){
        //调用ReturnReturnOrderService实现根据主键查询ReturnReturnOrder
        ReturnReturnOrder returnReturnOrder = returnReturnOrderService.findById(id);
        return new Result<ReturnReturnOrder>(true,StatusCode.OK,"查询成功",returnReturnOrder);
    }

    /***
     * 查询ReturnReturnOrder全部数据
     * @return
     */
    @GetMapping
    public Result<List<ReturnReturnOrder>> findAll(){
        //调用ReturnReturnOrderService实现查询所有ReturnReturnOrder
        List<ReturnReturnOrder> list = returnReturnOrderService.findAll();
        return new Result<List<ReturnReturnOrder>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
