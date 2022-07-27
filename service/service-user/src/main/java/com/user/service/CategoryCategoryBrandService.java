package com.user.service;

import com.user.pojo.CategoryCategoryBrand;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface CategoryCategoryBrandService {

    /***
     * CategoryCategoryBrand多条件分页查询
     * @param categoryCategoryBrand
     * @param page
     * @param size
     * @return
     */
    PageInfo<CategoryCategoryBrand> findPage(CategoryCategoryBrand categoryCategoryBrand, int page, int size);

    /***
     * CategoryCategoryBrand分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<CategoryCategoryBrand> findPage(int page, int size);

    /***
     * CategoryCategoryBrand多条件搜索方法
     * @param categoryCategoryBrand
     * @return
     */
    List<CategoryCategoryBrand> findList(CategoryCategoryBrand categoryCategoryBrand);

    /***
     * 删除CategoryCategoryBrand
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改CategoryCategoryBrand数据
     * @param categoryCategoryBrand
     */
    void update(CategoryCategoryBrand categoryCategoryBrand);

    /***
     * 新增CategoryCategoryBrand
     * @param categoryCategoryBrand
     */
    void add(CategoryCategoryBrand categoryCategoryBrand);

    /**
     * 根据ID查询CategoryCategoryBrand
     * @param id
     * @return
     */
     CategoryCategoryBrand findById(Integer id);

    /***
     * 查询所有CategoryCategoryBrand
     * @return
     */
    List<CategoryCategoryBrand> findAll();
}
