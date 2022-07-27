package com.order.service.impl;

import com.order.dao.ReturnReturnCauseMapper;
import com.order.pojo.ReturnReturnCause;
import com.order.service.ReturnReturnCauseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.order.dao.ReturnReturnCauseMapper;
import com.order.pojo.ReturnReturnCause;
import com.order.service.ReturnReturnCauseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class ReturnReturnCauseServiceImpl implements ReturnReturnCauseService {

    @Autowired
    private ReturnReturnCauseMapper returnReturnCauseMapper;


    /**
     * ReturnReturnCause条件+分页查询
     * @param returnReturnCause 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<ReturnReturnCause> findPage(ReturnReturnCause returnReturnCause, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(returnReturnCause);
        //执行搜索
        return new PageInfo<ReturnReturnCause>(returnReturnCauseMapper.selectByExample(example));
    }

    /**
     * ReturnReturnCause分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<ReturnReturnCause> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<ReturnReturnCause>(returnReturnCauseMapper.selectAll());
    }

    /**
     * ReturnReturnCause条件查询
     * @param returnReturnCause
     * @return
     */
    @Override
    public List<ReturnReturnCause> findList(ReturnReturnCause returnReturnCause){
        //构建查询条件
        Example example = createExample(returnReturnCause);
        //根据构建的条件查询数据
        return returnReturnCauseMapper.selectByExample(example);
    }


    /**
     * ReturnReturnCause构建查询对象
     * @param returnReturnCause
     * @return
     */
    public Example createExample(ReturnReturnCause returnReturnCause){
        Example example=new Example(ReturnReturnCause.class);
        Example.Criteria criteria = example.createCriteria();
        if(returnReturnCause!=null){
            // ID
            if(!StringUtils.isEmpty(returnReturnCause.getId())){
                    criteria.andEqualTo("id",returnReturnCause.getId());
            }
            // 原因
            if(!StringUtils.isEmpty(returnReturnCause.getCause())){
                    criteria.andEqualTo("cause",returnReturnCause.getCause());
            }
            // 排序
            if(!StringUtils.isEmpty(returnReturnCause.getSeq())){
                    criteria.andEqualTo("seq",returnReturnCause.getSeq());
            }
            // 是否启用
            if(!StringUtils.isEmpty(returnReturnCause.getStatus())){
                    criteria.andEqualTo("status",returnReturnCause.getStatus());
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
        returnReturnCauseMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改ReturnReturnCause
     * @param returnReturnCause
     */
    @Override
    public void update(ReturnReturnCause returnReturnCause){
        returnReturnCauseMapper.updateByPrimaryKey(returnReturnCause);
    }

    /**
     * 增加ReturnReturnCause
     * @param returnReturnCause
     */
    @Override
    public void add(ReturnReturnCause returnReturnCause){
        returnReturnCauseMapper.insert(returnReturnCause);
    }

    /**
     * 根据ID查询ReturnReturnCause
     * @param id
     * @return
     */
    @Override
    public ReturnReturnCause findById(Integer id){
        return  returnReturnCauseMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询ReturnReturnCause全部数据
     * @return
     */
    @Override
    public List<ReturnReturnCause> findAll() {
        return returnReturnCauseMapper.selectAll();
    }
}
