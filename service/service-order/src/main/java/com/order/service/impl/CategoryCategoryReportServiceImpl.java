package com.order.service.impl;

import com.order.dao.CategoryCategoryReportMapper;
import com.order.pojo.CategoryCategoryReport;
import com.order.service.CategoryCategoryReportService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;


@Service
public class CategoryCategoryReportServiceImpl implements CategoryCategoryReportService {

    @Autowired
    private CategoryCategoryReportMapper categoryCategoryReportMapper;


    /**
     * CategoryCategoryReport条件+分页查询
     * @param categoryCategoryReport 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<CategoryCategoryReport> findPage(CategoryCategoryReport categoryCategoryReport, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(categoryCategoryReport);
        //执行搜索
        return new PageInfo<CategoryCategoryReport>(categoryCategoryReportMapper.selectByExample(example));
    }

    /**
     * CategoryCategoryReport分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<CategoryCategoryReport> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<CategoryCategoryReport>(categoryCategoryReportMapper.selectAll());
    }

    /**
     * CategoryCategoryReport条件查询
     * @param categoryCategoryReport
     * @return
     */
    @Override
    public List<CategoryCategoryReport> findList(CategoryCategoryReport categoryCategoryReport){
        //构建查询条件
        Example example = createExample(categoryCategoryReport);
        //根据构建的条件查询数据
        return categoryCategoryReportMapper.selectByExample(example);
    }


    /**
     * CategoryCategoryReport构建查询对象
     * @param categoryCategoryReport
     * @return
     */
    public Example createExample(CategoryCategoryReport categoryCategoryReport){
        Example example=new Example(CategoryCategoryReport.class);
        Example.Criteria criteria = example.createCriteria();
        if(categoryCategoryReport!=null){
            // 1级分类
            if(!StringUtils.isEmpty(categoryCategoryReport.getCategoryCategoryId1())){
                    criteria.andEqualTo("categoryCategoryId1",categoryCategoryReport.getCategoryCategoryId1());
            }
            // 2级分类
            if(!StringUtils.isEmpty(categoryCategoryReport.getCategoryCategoryId2())){
                    criteria.andEqualTo("categoryCategoryId2",categoryCategoryReport.getCategoryCategoryId2());
            }
            // 3级分类
            if(!StringUtils.isEmpty(categoryCategoryReport.getCategoryCategoryId3())){
                    criteria.andEqualTo("categoryCategoryId3",categoryCategoryReport.getCategoryCategoryId3());
            }
            // 统计日期
            if(!StringUtils.isEmpty(categoryCategoryReport.getCountCountDate())){
                    criteria.andEqualTo("countCountDate",categoryCategoryReport.getCountCountDate());
            }
            // 销售数量
            if(!StringUtils.isEmpty(categoryCategoryReport.getNum())){
                    criteria.andEqualTo("num",categoryCategoryReport.getNum());
            }
            // 销售额
            if(!StringUtils.isEmpty(categoryCategoryReport.getMoney())){
                    criteria.andEqualTo("money",categoryCategoryReport.getMoney());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Date id){
        categoryCategoryReportMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改CategoryCategoryReport
     * @param categoryCategoryReport
     */
    @Override
    public void update(CategoryCategoryReport categoryCategoryReport){
        categoryCategoryReportMapper.updateByPrimaryKey(categoryCategoryReport);
    }

    /**
     * 增加CategoryCategoryReport
     * @param categoryCategoryReport
     */
    @Override
    public void add(CategoryCategoryReport categoryCategoryReport){
        categoryCategoryReportMapper.insert(categoryCategoryReport);
    }

    /**
     * 根据ID查询CategoryCategoryReport
     * @param id
     * @return
     */
    @Override
    public CategoryCategoryReport findById(Date id){
        return  categoryCategoryReportMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询CategoryCategoryReport全部数据
     * @return
     */
    @Override
    public List<CategoryCategoryReport> findAll() {
        return categoryCategoryReportMapper.selectAll();
    }
}
