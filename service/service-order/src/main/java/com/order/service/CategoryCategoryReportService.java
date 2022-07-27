package com.order.service;

import com.order.pojo.CategoryCategoryReport;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;


public interface CategoryCategoryReportService {

    /***
     * CategoryCategoryReport多条件分页查询
     * @param categoryCategoryReport
     * @param page
     * @param size
     * @return
     */
    PageInfo<CategoryCategoryReport> findPage(CategoryCategoryReport categoryCategoryReport, int page, int size);

    /***
     * CategoryCategoryReport分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<CategoryCategoryReport> findPage(int page, int size);

    /***
     * CategoryCategoryReport多条件搜索方法
     * @param categoryCategoryReport
     * @return
     */
    List<CategoryCategoryReport> findList(CategoryCategoryReport categoryCategoryReport);

    /***
     * 删除CategoryCategoryReport
     * @param id
     */
    void delete(Date id);

    /***
     * 修改CategoryCategoryReport数据
     * @param categoryCategoryReport
     */
    void update(CategoryCategoryReport categoryCategoryReport);

    /***
     * 新增CategoryCategoryReport
     * @param categoryCategoryReport
     */
    void add(CategoryCategoryReport categoryCategoryReport);

    /**
     * 根据ID查询CategoryCategoryReport
     * @param id
     * @return
     */
     CategoryCategoryReport findById(Date id);

    /***
     * 查询所有CategoryCategoryReport
     * @return
     */
    List<CategoryCategoryReport> findAll();
}
