package com.user.service.impl;

import com.user.dao.PrefMapper;
import com.user.pojo.Pref;
import com.user.service.PrefService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.user.dao.PrefMapper;
import com.user.service.PrefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class PrefServiceImpl implements PrefService {

    @Autowired
    private PrefMapper prefMapper;


    /**
     * Pref条件+分页查询
     * @param pref 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Pref> findPage(Pref pref, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pref);
        //执行搜索
        return new PageInfo<Pref>(prefMapper.selectByExample(example));
    }

    /**
     * Pref分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Pref> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Pref>(prefMapper.selectAll());
    }

    /**
     * Pref条件查询
     * @param pref
     * @return
     */
    @Override
    public List<Pref> findList(Pref pref){
        //构建查询条件
        Example example = createExample(pref);
        //根据构建的条件查询数据
        return prefMapper.selectByExample(example);
    }


    /**
     * Pref构建查询对象
     * @param pref
     * @return
     */
    public Example createExample(Pref pref){
        Example example=new Example(Pref.class);
        Example.Criteria criteria = example.createCriteria();
        if(pref!=null){
            // ID
            if(!StringUtils.isEmpty(pref.getId())){
                    criteria.andEqualTo("id",pref.getId());
            }
            // 分类ID
            if(!StringUtils.isEmpty(pref.getCateCateId())){
                    criteria.andEqualTo("cateCateId",pref.getCateCateId());
            }
            // 消费金额
            if(!StringUtils.isEmpty(pref.getBuyBuyMoney())){
                    criteria.andEqualTo("buyBuyMoney",pref.getBuyBuyMoney());
            }
            // 优惠金额
            if(!StringUtils.isEmpty(pref.getPrePreMoney())){
                    criteria.andEqualTo("prePreMoney",pref.getPrePreMoney());
            }
            // 活动开始日期
            if(!StringUtils.isEmpty(pref.getStartStartTime())){
                    criteria.andEqualTo("startStartTime",pref.getStartStartTime());
            }
            // 活动截至日期
            if(!StringUtils.isEmpty(pref.getEndEndTime())){
                    criteria.andEqualTo("endEndTime",pref.getEndEndTime());
            }
            // 类型,1:普通订单，2：限时活动
            if(!StringUtils.isEmpty(pref.getType())){
                    criteria.andEqualTo("type",pref.getType());
            }
            // 状态,1:有效，0：无效
            if(!StringUtils.isEmpty(pref.getState())){
                    criteria.andEqualTo("state",pref.getState());
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
        prefMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Pref
     * @param pref
     */
    @Override
    public void update(Pref pref){
        prefMapper.updateByPrimaryKey(pref);
    }

    /**
     * 增加Pref
     * @param pref
     */
    @Override
    public void add(Pref pref){
        prefMapper.insert(pref);
    }

    /**
     * 根据ID查询Pref
     * @param id
     * @return
     */
    @Override
    public Pref findById(Integer id){
        return  prefMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Pref全部数据
     * @return
     */
    @Override
    public List<Pref> findAll() {
        return prefMapper.selectAll();
    }
}
