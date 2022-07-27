package com.user.controller;

import com.user.pojo.PointPointLog;
import com.user.service.PointPointLogService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/pointPointLog")
@CrossOrigin
public class PointPointLogController {

    @Autowired
    private PointPointLogService pointPointLogService;

    /***
     * PointPointLog分页条件搜索实现
     * @param pointPointLog
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  PointPointLog pointPointLog, @PathVariable  int page, @PathVariable  int size){
        //调用PointPointLogService实现分页条件查询PointPointLog
        PageInfo<PointPointLog> pageInfo = pointPointLogService.findPage(pointPointLog, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * PointPointLog分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PointPointLogService实现分页查询PointPointLog
        PageInfo<PointPointLog> pageInfo = pointPointLogService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pointPointLog
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<PointPointLog>> findList(@RequestBody(required = false)  PointPointLog pointPointLog){
        //调用PointPointLogService实现条件查询PointPointLog
        List<PointPointLog> list = pointPointLogService.findList(pointPointLog);
        return new Result<List<PointPointLog>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用PointPointLogService实现根据主键删除
        pointPointLogService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改PointPointLog数据
     * @param pointPointLog
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  PointPointLog pointPointLog,@PathVariable String id){
        //设置主键值
        pointPointLog.setOrderOrderId(id);
        //调用PointPointLogService实现修改PointPointLog
        pointPointLogService.update(pointPointLog);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增PointPointLog数据
     * @param pointPointLog
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   PointPointLog pointPointLog){
        //调用PointPointLogService实现添加PointPointLog
        pointPointLogService.add(pointPointLog);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询PointPointLog数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<PointPointLog> findById(@PathVariable String id){
        //调用PointPointLogService实现根据主键查询PointPointLog
        PointPointLog pointPointLog = pointPointLogService.findById(id);
        return new Result<PointPointLog>(true,StatusCode.OK,"查询成功",pointPointLog);
    }

    /***
     * 查询PointPointLog全部数据
     * @return
     */
    @GetMapping
    public Result<List<PointPointLog>> findAll(){
        //调用PointPointLogService实现查询所有PointPointLog
        List<PointPointLog> list = pointPointLogService.findAll();
        return new Result<List<PointPointLog>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
