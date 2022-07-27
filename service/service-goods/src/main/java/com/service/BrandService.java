package com.service;

import com.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    public List<Brand> findAll();
     Brand findById(Integer id);
    void add(Brand brand);
    void update(Brand brand);
    void delete(Integer id);
    List<Brand> findList(Brand brand);
    /*
    条件搜索分页
     */
    PageInfo<Brand> findPage(Integer page,Integer size);
    PageInfo<Brand> findPage(Brand brand,Integer page,Integer size);
    /**
     * 根据分类Id查询品牌集合
     * @param categoryId :分类
     */
    List<Brand> findByCategory(int categoryId);
}
