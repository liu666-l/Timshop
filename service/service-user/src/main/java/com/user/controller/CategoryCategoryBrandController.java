package com.user.controller;

import com.user.pojo.CategoryCategoryBrand;
import com.user.service.CategoryCategoryBrandService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/categoryCategoryBrand")
@CrossOrigin
public class CategoryCategoryBrandController {

    @Autowired
    private CategoryCategoryBrandService categoryCategoryBrandService;

    /***
     * CategoryCategoryBrand分页条件搜索实现
     * @param categoryCategoryBrand
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  CategoryCategoryBrand categoryCategoryBrand, @PathVariable  int page, @PathVariable  int size){
        //调用CategoryCategoryBrandService实现分页条件查询CategoryCategoryBrand
        PageInfo<CategoryCategoryBrand> pageInfo = categoryCategoryBrandService.findPage(categoryCategoryBrand, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * CategoryCategoryBrand分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用CategoryCategoryBrandService实现分页查询CategoryCategoryBrand
        PageInfo<CategoryCategoryBrand> pageInfo = categoryCategoryBrandService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param categoryCategoryBrand
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<CategoryCategoryBrand>> findList(@RequestBody(required = false)  CategoryCategoryBrand categoryCategoryBrand){
        //调用CategoryCategoryBrandService实现条件查询CategoryCategoryBrand
        List<CategoryCategoryBrand> list = categoryCategoryBrandService.findList(categoryCategoryBrand);
        return new Result<List<CategoryCategoryBrand>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用CategoryCategoryBrandService实现根据主键删除
        categoryCategoryBrandService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改CategoryCategoryBrand数据
     * @param categoryCategoryBrand
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  CategoryCategoryBrand categoryCategoryBrand,@PathVariable Integer id){
        //设置主键值
        categoryCategoryBrand.setBrandBrandId(id);
        //调用CategoryCategoryBrandService实现修改CategoryCategoryBrand
        categoryCategoryBrandService.update(categoryCategoryBrand);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增CategoryCategoryBrand数据
     * @param categoryCategoryBrand
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   CategoryCategoryBrand categoryCategoryBrand){
        //调用CategoryCategoryBrandService实现添加CategoryCategoryBrand
        categoryCategoryBrandService.add(categoryCategoryBrand);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询CategoryCategoryBrand数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<CategoryCategoryBrand> findById(@PathVariable Integer id){
        //调用CategoryCategoryBrandService实现根据主键查询CategoryCategoryBrand
        CategoryCategoryBrand categoryCategoryBrand = categoryCategoryBrandService.findById(id);
        return new Result<CategoryCategoryBrand>(true,StatusCode.OK,"查询成功",categoryCategoryBrand);
    }

    /***
     * 查询CategoryCategoryBrand全部数据
     * @return
     */
    @GetMapping
    public Result<List<CategoryCategoryBrand>> findAll(){
        //调用CategoryCategoryBrandService实现查询所有CategoryCategoryBrand
        List<CategoryCategoryBrand> list = categoryCategoryBrandService.findAll();
        return new Result<List<CategoryCategoryBrand>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
