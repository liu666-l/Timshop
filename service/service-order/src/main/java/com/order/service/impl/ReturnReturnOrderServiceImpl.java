package com.order.service.impl;

import com.order.dao.ReturnReturnOrderMapper;
import com.order.pojo.ReturnReturnOrder;
import com.order.service.ReturnReturnOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class ReturnReturnOrderServiceImpl implements ReturnReturnOrderService {

    @Autowired
    private ReturnReturnOrderMapper returnReturnOrderMapper;


    /**
     * ReturnReturnOrder条件+分页查询
     * @param returnReturnOrder 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<ReturnReturnOrder> findPage(ReturnReturnOrder returnReturnOrder, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(returnReturnOrder);
        //执行搜索
        return new PageInfo<ReturnReturnOrder>(returnReturnOrderMapper.selectByExample(example));
    }

    /**
     * ReturnReturnOrder分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<ReturnReturnOrder> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<ReturnReturnOrder>(returnReturnOrderMapper.selectAll());
    }

    /**
     * ReturnReturnOrder条件查询
     * @param returnReturnOrder
     * @return
     */
    @Override
    public List<ReturnReturnOrder> findList(ReturnReturnOrder returnReturnOrder){
        //构建查询条件
        Example example = createExample(returnReturnOrder);
        //根据构建的条件查询数据
        return returnReturnOrderMapper.selectByExample(example);
    }


    /**
     * ReturnReturnOrder构建查询对象
     * @param returnReturnOrder
     * @return
     */
    public Example createExample(ReturnReturnOrder returnReturnOrder){
        Example example=new Example(ReturnReturnOrder.class);
        Example.Criteria criteria = example.createCriteria();
        if(returnReturnOrder!=null){
            // 服务单号
            if(!StringUtils.isEmpty(returnReturnOrder.getId())){
                    criteria.andEqualTo("id",returnReturnOrder.getId());
            }
            // 订单号
            if(!StringUtils.isEmpty(returnReturnOrder.getOrderOrderId())){
                    criteria.andEqualTo("orderOrderId",returnReturnOrder.getOrderOrderId());
            }
            // 申请时间
            if(!StringUtils.isEmpty(returnReturnOrder.getApplyApplyTime())){
                    criteria.andEqualTo("applyApplyTime",returnReturnOrder.getApplyApplyTime());
            }
            // 用户ID
            if(!StringUtils.isEmpty(returnReturnOrder.getUserUserId())){
                    criteria.andEqualTo("userUserId",returnReturnOrder.getUserUserId());
            }
            // 用户账号
            if(!StringUtils.isEmpty(returnReturnOrder.getUserUserAccount())){
                    criteria.andEqualTo("userUserAccount",returnReturnOrder.getUserUserAccount());
            }
            // 联系人
            if(!StringUtils.isEmpty(returnReturnOrder.getLinkman())){
                    criteria.andEqualTo("linkman",returnReturnOrder.getLinkman());
            }
            // 联系人手机
            if(!StringUtils.isEmpty(returnReturnOrder.getLinkmanLinkmanMobile())){
                    criteria.andEqualTo("linkmanLinkmanMobile",returnReturnOrder.getLinkmanLinkmanMobile());
            }
            // 类型
            if(!StringUtils.isEmpty(returnReturnOrder.getType())){
                    criteria.andEqualTo("type",returnReturnOrder.getType());
            }
            // 退款金额
            if(!StringUtils.isEmpty(returnReturnOrder.getReturnReturnMoney())){
                    criteria.andEqualTo("returnReturnMoney",returnReturnOrder.getReturnReturnMoney());
            }
            // 是否退运费
            if(!StringUtils.isEmpty(returnReturnOrder.getIsIsReturnFreight())){
                    criteria.andEqualTo("isIsReturnFreight",returnReturnOrder.getIsIsReturnFreight());
            }
            // 申请状态
            if(!StringUtils.isEmpty(returnReturnOrder.getStatus())){
                    criteria.andEqualTo("status",returnReturnOrder.getStatus());
            }
            // 处理时间
            if(!StringUtils.isEmpty(returnReturnOrder.getDisposeDisposeTime())){
                    criteria.andEqualTo("disposeDisposeTime",returnReturnOrder.getDisposeDisposeTime());
            }
            // 退货退款原因
            if(!StringUtils.isEmpty(returnReturnOrder.getReturnReturnCause())){
                    criteria.andEqualTo("returnReturnCause",returnReturnOrder.getReturnReturnCause());
            }
            // 凭证图片
            if(!StringUtils.isEmpty(returnReturnOrder.getEvidence())){
                    criteria.andEqualTo("evidence",returnReturnOrder.getEvidence());
            }
            // 问题描述
            if(!StringUtils.isEmpty(returnReturnOrder.getDescription())){
                    criteria.andEqualTo("description",returnReturnOrder.getDescription());
            }
            // 处理备注
            if(!StringUtils.isEmpty(returnReturnOrder.getRemark())){
                    criteria.andEqualTo("remark",returnReturnOrder.getRemark());
            }
            // 管理员id
            if(!StringUtils.isEmpty(returnReturnOrder.getAdminAdminId())){
                    criteria.andEqualTo("adminAdminId",returnReturnOrder.getAdminAdminId());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(String id){
        returnReturnOrderMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改ReturnReturnOrder
     * @param returnReturnOrder
     */
    @Override
    public void update(ReturnReturnOrder returnReturnOrder){
        returnReturnOrderMapper.updateByPrimaryKey(returnReturnOrder);
    }

    /**
     * 增加ReturnReturnOrder
     * @param returnReturnOrder
     */
    @Override
    public void add(ReturnReturnOrder returnReturnOrder){
        returnReturnOrderMapper.insert(returnReturnOrder);
    }

    /**
     * 根据ID查询ReturnReturnOrder
     * @param id
     * @return
     */
    @Override
    public ReturnReturnOrder findById(String id){
        return  returnReturnOrderMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询ReturnReturnOrder全部数据
     * @return
     */
    @Override
    public List<ReturnReturnOrder> findAll() {
        return returnReturnOrderMapper.selectAll();
    }
}
