package com.order.controller;

import com.order.pojo.OrderOrderConfig;
import com.order.service.OrderOrderConfigService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderOrderConfig")
@CrossOrigin
public class OrderOrderConfigController {

    @Autowired
    private OrderOrderConfigService orderOrderConfigService;

    /***
     * OrderOrderConfig分页条件搜索实现
     * @param orderOrderConfig
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  OrderOrderConfig orderOrderConfig, @PathVariable  int page, @PathVariable  int size){
        //调用OrderOrderConfigService实现分页条件查询OrderOrderConfig
        PageInfo<OrderOrderConfig> pageInfo = orderOrderConfigService.findPage(orderOrderConfig, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * OrderOrderConfig分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OrderOrderConfigService实现分页查询OrderOrderConfig
        PageInfo<OrderOrderConfig> pageInfo = orderOrderConfigService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param orderOrderConfig
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<OrderOrderConfig>> findList(@RequestBody(required = false)  OrderOrderConfig orderOrderConfig){
        //调用OrderOrderConfigService实现条件查询OrderOrderConfig
        List<OrderOrderConfig> list = orderOrderConfigService.findList(orderOrderConfig);
        return new Result<List<OrderOrderConfig>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用OrderOrderConfigService实现根据主键删除
        orderOrderConfigService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改OrderOrderConfig数据
     * @param orderOrderConfig
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  OrderOrderConfig orderOrderConfig,@PathVariable Integer id){
        //设置主键值
        orderOrderConfig.setId(id);
        //调用OrderOrderConfigService实现修改OrderOrderConfig
        orderOrderConfigService.update(orderOrderConfig);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增OrderOrderConfig数据
     * @param orderOrderConfig
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   OrderOrderConfig orderOrderConfig){
        //调用OrderOrderConfigService实现添加OrderOrderConfig
        orderOrderConfigService.add(orderOrderConfig);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询OrderOrderConfig数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<OrderOrderConfig> findById(@PathVariable Integer id){
        //调用OrderOrderConfigService实现根据主键查询OrderOrderConfig
        OrderOrderConfig orderOrderConfig = orderOrderConfigService.findById(id);
        return new Result<OrderOrderConfig>(true,StatusCode.OK,"查询成功",orderOrderConfig);
    }

    /***
     * 查询OrderOrderConfig全部数据
     * @return
     */
    @GetMapping
    public Result<List<OrderOrderConfig>> findAll(){
        //调用OrderOrderConfigService实现查询所有OrderOrderConfig
        List<OrderOrderConfig> list = orderOrderConfigService.findAll();
        return new Result<List<OrderOrderConfig>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
