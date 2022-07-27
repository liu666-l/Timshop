package com.order.controller;

import com.order.pojo.TaskTaskHis;
import com.order.service.TaskTaskHisService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/taskTaskHis")
@CrossOrigin
public class TaskTaskHisController {

    @Autowired
    private TaskTaskHisService taskTaskHisService;

    /***
     * TaskTaskHis分页条件搜索实现
     * @param taskTaskHis
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  TaskTaskHis taskTaskHis, @PathVariable  int page, @PathVariable  int size){
        //调用TaskTaskHisService实现分页条件查询TaskTaskHis
        PageInfo<TaskTaskHis> pageInfo = taskTaskHisService.findPage(taskTaskHis, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * TaskTaskHis分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用TaskTaskHisService实现分页查询TaskTaskHis
        PageInfo<TaskTaskHis> pageInfo = taskTaskHisService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param taskTaskHis
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<TaskTaskHis>> findList(@RequestBody(required = false)  TaskTaskHis taskTaskHis){
        //调用TaskTaskHisService实现条件查询TaskTaskHis
        List<TaskTaskHis> list = taskTaskHisService.findList(taskTaskHis);
        return new Result<List<TaskTaskHis>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用TaskTaskHisService实现根据主键删除
        taskTaskHisService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改TaskTaskHis数据
     * @param taskTaskHis
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  TaskTaskHis taskTaskHis,@PathVariable Long id){
        //设置主键值
        taskTaskHis.setId(id);
        //调用TaskTaskHisService实现修改TaskTaskHis
        taskTaskHisService.update(taskTaskHis);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增TaskTaskHis数据
     * @param taskTaskHis
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   TaskTaskHis taskTaskHis){
        //调用TaskTaskHisService实现添加TaskTaskHis
        taskTaskHisService.add(taskTaskHis);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询TaskTaskHis数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<TaskTaskHis> findById(@PathVariable Long id){
        //调用TaskTaskHisService实现根据主键查询TaskTaskHis
        TaskTaskHis taskTaskHis = taskTaskHisService.findById(id);
        return new Result<TaskTaskHis>(true,StatusCode.OK,"查询成功",taskTaskHis);
    }

    /***
     * 查询TaskTaskHis全部数据
     * @return
     */
    @GetMapping
    public Result<List<TaskTaskHis>> findAll(){
        //调用TaskTaskHisService实现查询所有TaskTaskHis
        List<TaskTaskHis> list = taskTaskHisService.findAll();
        return new Result<List<TaskTaskHis>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
