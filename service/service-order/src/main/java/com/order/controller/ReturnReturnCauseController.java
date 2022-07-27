package com.order.controller;

import com.order.pojo.ReturnReturnCause;
import com.order.service.ReturnReturnCauseService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/returnReturnCause")
@CrossOrigin
public class ReturnReturnCauseController {

    @Autowired
    private ReturnReturnCauseService returnReturnCauseService;

    /***
     * ReturnReturnCause分页条件搜索实现
     * @param returnReturnCause
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  ReturnReturnCause returnReturnCause, @PathVariable  int page, @PathVariable  int size){
        //调用ReturnReturnCauseService实现分页条件查询ReturnReturnCause
        PageInfo<ReturnReturnCause> pageInfo = returnReturnCauseService.findPage(returnReturnCause, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * ReturnReturnCause分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ReturnReturnCauseService实现分页查询ReturnReturnCause
        PageInfo<ReturnReturnCause> pageInfo = returnReturnCauseService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param returnReturnCause
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<ReturnReturnCause>> findList(@RequestBody(required = false)  ReturnReturnCause returnReturnCause){
        //调用ReturnReturnCauseService实现条件查询ReturnReturnCause
        List<ReturnReturnCause> list = returnReturnCauseService.findList(returnReturnCause);
        return new Result<List<ReturnReturnCause>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用ReturnReturnCauseService实现根据主键删除
        returnReturnCauseService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改ReturnReturnCause数据
     * @param returnReturnCause
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  ReturnReturnCause returnReturnCause,@PathVariable Integer id){
        //设置主键值
        returnReturnCause.setId(id);
        //调用ReturnReturnCauseService实现修改ReturnReturnCause
        returnReturnCauseService.update(returnReturnCause);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增ReturnReturnCause数据
     * @param returnReturnCause
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   ReturnReturnCause returnReturnCause){
        //调用ReturnReturnCauseService实现添加ReturnReturnCause
        returnReturnCauseService.add(returnReturnCause);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询ReturnReturnCause数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<ReturnReturnCause> findById(@PathVariable Integer id){
        //调用ReturnReturnCauseService实现根据主键查询ReturnReturnCause
        ReturnReturnCause returnReturnCause = returnReturnCauseService.findById(id);
        return new Result<ReturnReturnCause>(true,StatusCode.OK,"查询成功",returnReturnCause);
    }

    /***
     * 查询ReturnReturnCause全部数据
     * @return
     */
    @GetMapping
    public Result<List<ReturnReturnCause>> findAll(){
        //调用ReturnReturnCauseService实现查询所有ReturnReturnCause
        List<ReturnReturnCause> list = returnReturnCauseService.findAll();
        return new Result<List<ReturnReturnCause>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
