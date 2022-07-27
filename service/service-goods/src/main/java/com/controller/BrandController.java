package com.controller;

import com.goods.pojo.Brand;
import com.service.BrandService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
@CrossOrigin//跨域访问
public class BrandController {
    @Autowired
    private BrandService brandService;
    @GetMapping
    public Result<List<Brand>> fillAll(){
        List<Brand> brands= brandService.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK,"查询品牌成功",brands);
    }
    @GetMapping(value = "/{id}")
    public Result<Brand> findById(@PathVariable("id") Integer id){
        Brand brands= brandService.findById(id);
        return new Result<Brand>(true, StatusCode.OK,"查询id品牌成功",brands);
    }
    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true, StatusCode.OK,"查询id品牌成功");

    }
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable(value = "id") Integer id,@RequestBody Brand brand){
        brand.setId(id);
        brandService.update(brand);
        return new Result(true,StatusCode.OK,"修改成弓");
    }
    @DeleteMapping(value = "/id")
    public Result delete(@PathVariable("id")Integer id){
        brandService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");

    }
/*
条件查询
 */
    @PostMapping(value = "/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand){
        List<Brand> brands= brandService.findList(brand);
        return new Result<List<Brand>>(true,StatusCode.OK,"条件查询成功",brands);

    }
//    @GetMapping(value = "search/{page}/{size}")
//    public Result<PageInfo<Brand>> findPage(@RequestBody Brand brand,@PathVariable(value = "page") Integer page,
//                                            @PathVariable(value = "size") Integer size){
//        PageInfo<Brand> pageInfo= brandService.findPage(brand,page,size);
//        return new Result<PageInfo<Brand>>(true,StatusCode.OK,"分页查询成功",pageInfo);
//    }
    /*
    分页查询
     */
    @GetMapping(value = "search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@PathVariable(value = "page") Integer page,
                                            @PathVariable(value = "size") Integer size){
        PageInfo<Brand> pageInfo= brandService.findPage(page,size);
        return new Result<PageInfo<Brand>>(true,StatusCode.OK,"分页查询成功",pageInfo);
    }
    /**
     * 根据分类id查询对应的品牌集合
     * @param categoryId
     * @return
     * Controller层 BrandController.java
     */
    @GetMapping("/category/{id}")
    public Result<List<Brand>> findByCategory(@PathVariable("id") int categoryId) {
        List<Brand> brands = brandService.findByCategory(categoryId);
        return new Result<>(true,StatusCode.OK,"查询成功",brands);
    }

}
