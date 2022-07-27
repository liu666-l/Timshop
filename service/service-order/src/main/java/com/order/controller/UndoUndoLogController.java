package com.order.controller;

import com.order.pojo.UndoUndoLog;
import com.order.service.UndoUndoLogService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/undoUndoLog")
@CrossOrigin
public class UndoUndoLogController {

    @Autowired
    private UndoUndoLogService undoUndoLogService;

    /***
     * UndoUndoLog分页条件搜索实现
     * @param undoUndoLog
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  UndoUndoLog undoUndoLog, @PathVariable  int page, @PathVariable  int size){
        //调用UndoUndoLogService实现分页条件查询UndoUndoLog
        PageInfo<UndoUndoLog> pageInfo = undoUndoLogService.findPage(undoUndoLog, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * UndoUndoLog分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用UndoUndoLogService实现分页查询UndoUndoLog
        PageInfo<UndoUndoLog> pageInfo = undoUndoLogService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param undoUndoLog
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<UndoUndoLog>> findList(@RequestBody(required = false)  UndoUndoLog undoUndoLog){
        //调用UndoUndoLogService实现条件查询UndoUndoLog
        List<UndoUndoLog> list = undoUndoLogService.findList(undoUndoLog);
        return new Result<List<UndoUndoLog>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用UndoUndoLogService实现根据主键删除
        undoUndoLogService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改UndoUndoLog数据
     * @param undoUndoLog
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  UndoUndoLog undoUndoLog,@PathVariable Long id){
        //设置主键值
        undoUndoLog.setId(id);
        //调用UndoUndoLogService实现修改UndoUndoLog
        undoUndoLogService.update(undoUndoLog);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增UndoUndoLog数据
     * @param undoUndoLog
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   UndoUndoLog undoUndoLog){
        //调用UndoUndoLogService实现添加UndoUndoLog
        undoUndoLogService.add(undoUndoLog);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询UndoUndoLog数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<UndoUndoLog> findById(@PathVariable Long id){
        //调用UndoUndoLogService实现根据主键查询UndoUndoLog
        UndoUndoLog undoUndoLog = undoUndoLogService.findById(id);
        return new Result<UndoUndoLog>(true,StatusCode.OK,"查询成功",undoUndoLog);
    }

    /***
     * 查询UndoUndoLog全部数据
     * @return
     */
    @GetMapping
    public Result<List<UndoUndoLog>> findAll(){
        //调用UndoUndoLogService实现查询所有UndoUndoLog
        List<UndoUndoLog> list = undoUndoLogService.findAll();
        return new Result<List<UndoUndoLog>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
