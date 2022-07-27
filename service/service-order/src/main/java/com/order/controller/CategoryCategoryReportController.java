package com.order.controller;

import com.order.pojo.CategoryCategoryReport;
import com.order.service.CategoryCategoryReportService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;



@RestController
@RequestMapping("/categoryCategoryReport")
@CrossOrigin
public class CategoryCategoryReportController {

    @Autowired
    private CategoryCategoryReportService categoryCategoryReportService;

    /***
     * CategoryCategoryReport分页条件搜索实现
     * @param categoryCategoryReport
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  CategoryCategoryReport categoryCategoryReport, @PathVariable  int page, @PathVariable  int size){
        //调用CategoryCategoryReportService实现分页条件查询CategoryCategoryReport
        PageInfo<CategoryCategoryReport> pageInfo = categoryCategoryReportService.findPage(categoryCategoryReport, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * CategoryCategoryReport分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用CategoryCategoryReportService实现分页查询CategoryCategoryReport
        PageInfo<CategoryCategoryReport> pageInfo = categoryCategoryReportService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param categoryCategoryReport
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<CategoryCategoryReport>> findList(@RequestBody(required = false)  CategoryCategoryReport categoryCategoryReport){
        //调用CategoryCategoryReportService实现条件查询CategoryCategoryReport
        List<CategoryCategoryReport> list = categoryCategoryReportService.findList(categoryCategoryReport);
        return new Result<List<CategoryCategoryReport>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Date id){
        //调用CategoryCategoryReportService实现根据主键删除
        categoryCategoryReportService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改CategoryCategoryReport数据
     * @param categoryCategoryReport
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  CategoryCategoryReport categoryCategoryReport,@PathVariable Date id){
        //设置主键值
        categoryCategoryReport.setCountCountDate(id);
        //调用CategoryCategoryReportService实现修改CategoryCategoryReport
        categoryCategoryReportService.update(categoryCategoryReport);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增CategoryCategoryReport数据
     * @param categoryCategoryReport
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   CategoryCategoryReport categoryCategoryReport){
        //调用CategoryCategoryReportService实现添加CategoryCategoryReport
        categoryCategoryReportService.add(categoryCategoryReport);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询CategoryCategoryReport数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<CategoryCategoryReport> findById(@PathVariable Date id){
        //调用CategoryCategoryReportService实现根据主键查询CategoryCategoryReport
        CategoryCategoryReport categoryCategoryReport = categoryCategoryReportService.findById(id);
        return new Result<CategoryCategoryReport>(true,StatusCode.OK,"查询成功",categoryCategoryReport);
    }

    /***
     * 查询CategoryCategoryReport全部数据
     * @return
     */
    @GetMapping
    public Result<List<CategoryCategoryReport>> findAll(){
        //调用CategoryCategoryReportService实现查询所有CategoryCategoryReport
        List<CategoryCategoryReport> list = categoryCategoryReportService.findAll();
        return new Result<List<CategoryCategoryReport>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
