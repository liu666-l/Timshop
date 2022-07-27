package com.user.service.impl;

import com.user.dao.CategoryCategoryBrandMapper;
import com.user.pojo.CategoryCategoryBrand;
import com.user.service.CategoryCategoryBrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.user.dao.CategoryCategoryBrandMapper;
import com.user.pojo.CategoryCategoryBrand;
import com.user.service.CategoryCategoryBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class CategoryCategoryBrandServiceImpl implements CategoryCategoryBrandService {

    @Autowired
    private CategoryCategoryBrandMapper categoryCategoryBrandMapper;


    /**
     * CategoryCategoryBrand条件+分页查询
     * @param categoryCategoryBrand 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<CategoryCategoryBrand> findPage(CategoryCategoryBrand categoryCategoryBrand, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(categoryCategoryBrand);
        //执行搜索
        return new PageInfo<CategoryCategoryBrand>(categoryCategoryBrandMapper.selectByExample(example));
    }

    /**
     * CategoryCategoryBrand分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<CategoryCategoryBrand> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<CategoryCategoryBrand>(categoryCategoryBrandMapper.selectAll());
    }

    /**
     * CategoryCategoryBrand条件查询
     * @param categoryCategoryBrand
     * @return
     */
    @Override
    public List<CategoryCategoryBrand> findList(CategoryCategoryBrand categoryCategoryBrand){
        //构建查询条件
        Example example = createExample(categoryCategoryBrand);
        //根据构建的条件查询数据
        return categoryCategoryBrandMapper.selectByExample(example);
    }


    /**
     * CategoryCategoryBrand构建查询对象
     * @param categoryCategoryBrand
     * @return
     */
    public Example createExample(CategoryCategoryBrand categoryCategoryBrand){
        Example example=new Example(CategoryCategoryBrand.class);
        Example.Criteria criteria = example.createCriteria();
        if(categoryCategoryBrand!=null){
            // 分类ID
            if(!StringUtils.isEmpty(categoryCategoryBrand.getCategoryCategoryId())){
                    criteria.andEqualTo("categoryCategoryId",categoryCategoryBrand.getCategoryCategoryId());
            }
            // 品牌ID
            if(!StringUtils.isEmpty(categoryCategoryBrand.getBrandBrandId())){
                    criteria.andEqualTo("brandBrandId",categoryCategoryBrand.getBrandBrandId());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        categoryCategoryBrandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改CategoryCategoryBrand
     * @param categoryCategoryBrand
     */
    @Override
    public void update(CategoryCategoryBrand categoryCategoryBrand){
        categoryCategoryBrandMapper.updateByPrimaryKey(categoryCategoryBrand);
    }

    /**
     * 增加CategoryCategoryBrand
     * @param categoryCategoryBrand
     */
    @Override
    public void add(CategoryCategoryBrand categoryCategoryBrand){
        categoryCategoryBrandMapper.insert(categoryCategoryBrand);
    }

    /**
     * 根据ID查询CategoryCategoryBrand
     * @param id
     * @return
     */
    @Override
    public CategoryCategoryBrand findById(Integer id){
        return  categoryCategoryBrandMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询CategoryCategoryBrand全部数据
     * @return
     */
    @Override
    public List<CategoryCategoryBrand> findAll() {
        return categoryCategoryBrandMapper.selectAll();
    }
}
