package com.user.controller;

import com.user.pojo.StockStockBack;
import com.user.service.StockStockBackService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/stockStockBack")
@CrossOrigin
public class StockStockBackController {

    @Autowired
    private StockStockBackService stockStockBackService;

    /***
     * StockStockBack分页条件搜索实现
     * @param stockStockBack
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  StockStockBack stockStockBack, @PathVariable  int page, @PathVariable  int size){
        //调用StockStockBackService实现分页条件查询StockStockBack
        PageInfo<StockStockBack> pageInfo = stockStockBackService.findPage(stockStockBack, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * StockStockBack分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用StockStockBackService实现分页查询StockStockBack
        PageInfo<StockStockBack> pageInfo = stockStockBackService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param stockStockBack
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<StockStockBack>> findList(@RequestBody(required = false)  StockStockBack stockStockBack){
        //调用StockStockBackService实现条件查询StockStockBack
        List<StockStockBack> list = stockStockBackService.findList(stockStockBack);
        return new Result<List<StockStockBack>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用StockStockBackService实现根据主键删除
        stockStockBackService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改StockStockBack数据
     * @param stockStockBack
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  StockStockBack stockStockBack,@PathVariable String id){
        //设置主键值
        stockStockBack.setSkuSkuId(id);
        //调用StockStockBackService实现修改StockStockBack
        stockStockBackService.update(stockStockBack);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增StockStockBack数据
     * @param stockStockBack
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   StockStockBack stockStockBack){
        //调用StockStockBackService实现添加StockStockBack
        stockStockBackService.add(stockStockBack);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询StockStockBack数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<StockStockBack> findById(@PathVariable String id){
        //调用StockStockBackService实现根据主键查询StockStockBack
        StockStockBack stockStockBack = stockStockBackService.findById(id);
        return new Result<StockStockBack>(true,StatusCode.OK,"查询成功",stockStockBack);
    }

    /***
     * 查询StockStockBack全部数据
     * @return
     */
    @GetMapping
    public Result<List<StockStockBack>> findAll(){
        //调用StockStockBackService实现查询所有StockStockBack
        List<StockStockBack> list = stockStockBackService.findAll();
        return new Result<List<StockStockBack>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
