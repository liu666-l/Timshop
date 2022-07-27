package com.service.impl;

import com.dao.BrandMapper;
import com.goods.pojo.Brand;
import com.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class BrandServiceImpl implements BrandService {


    @Override
    public PageInfo<Brand> findPage(Brand brand, Integer page, Integer size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索数据
        Example exapmle = createExapmle(brand);
        List<Brand> brands= brandMapper.selectByExample(exapmle);
        //封装
        return new PageInfo<Brand>(brands);
    }

    @Override
    public List<Brand> findByCategory(int categoryId) {

        return brandMapper.findByCategory(categoryId);
    }

    @Override
    public PageInfo<Brand> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        //查询集合
        List<Brand> brands= brandMapper.selectAll();
        //封装PageInfo->list
        return new PageInfo<Brand>(brands);

    }

    @Override
    public List<Brand> findList(Brand brand) {
        Example example=new Example(Brand.class);
        Example.Criteria criteria=example.createCriteria();
        if(brand!=null){
            if(!StringUtils.isEmpty(brand.getName())){
                criteria.andLike("name", "%"+brand.getName()+"%");
            }
            if(!StringUtils.isEmpty(brand.getLetter())){
                criteria.andEqualTo("letter",brand.getLetter());
            }
        }
        return brandMapper.selectByExample(example);
    }
    public Example createExapmle(Brand brand){
        Example example=new Example(Brand.class);
        //条件构造器
        Example.Criteria criteria= example.createCriteria();
        if(brand!=null){
            if(!StringUtils.isEmpty(brand.getName())){
                criteria.andLike("name", "%"+brand.getName()+"%");
            }
            if(!StringUtils.isEmpty(brand.getLetter())){
                criteria.andEqualTo("letter",brand.getLetter());
            }
        }
        return example;

    }

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }
    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }
}
