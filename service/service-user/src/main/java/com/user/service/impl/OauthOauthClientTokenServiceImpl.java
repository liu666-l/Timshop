package com.user.service.impl;

import com.user.dao.OauthOauthClientTokenMapper;
import com.user.pojo.OauthOauthClientToken;
import com.user.service.OauthOauthClientTokenService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.user.dao.OauthOauthClientTokenMapper;
import com.user.pojo.OauthOauthClientToken;
import com.user.service.OauthOauthClientTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class OauthOauthClientTokenServiceImpl implements OauthOauthClientTokenService {

    @Autowired
    private OauthOauthClientTokenMapper oauthOauthClientTokenMapper;


    /**
     * OauthOauthClientToken条件+分页查询
     * @param oauthOauthClientToken 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OauthOauthClientToken> findPage(OauthOauthClientToken oauthOauthClientToken, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(oauthOauthClientToken);
        //执行搜索
        return new PageInfo<OauthOauthClientToken>(oauthOauthClientTokenMapper.selectByExample(example));
    }

    /**
     * OauthOauthClientToken分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OauthOauthClientToken> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OauthOauthClientToken>(oauthOauthClientTokenMapper.selectAll());
    }

    /**
     * OauthOauthClientToken条件查询
     * @param oauthOauthClientToken
     * @return
     */
    @Override
    public List<OauthOauthClientToken> findList(OauthOauthClientToken oauthOauthClientToken){
        //构建查询条件
        Example example = createExample(oauthOauthClientToken);
        //根据构建的条件查询数据
        return oauthOauthClientTokenMapper.selectByExample(example);
    }


    /**
     * OauthOauthClientToken构建查询对象
     * @param oauthOauthClientToken
     * @return
     */
    public Example createExample(OauthOauthClientToken oauthOauthClientToken){
        Example example=new Example(OauthOauthClientToken.class);
        Example.Criteria criteria = example.createCriteria();
        if(oauthOauthClientToken!=null){
            // 
            if(!StringUtils.isEmpty(oauthOauthClientToken.getTokenTokenId())){
                    criteria.andEqualTo("tokenTokenId",oauthOauthClientToken.getTokenTokenId());
            }
            // 
            if(!StringUtils.isEmpty(oauthOauthClientToken.getToken())){
                    criteria.andEqualTo("token",oauthOauthClientToken.getToken());
            }
            // 
            if(!StringUtils.isEmpty(oauthOauthClientToken.getAuthenticationAuthenticationId())){
                    criteria.andEqualTo("authenticationAuthenticationId",oauthOauthClientToken.getAuthenticationAuthenticationId());
            }
            // 
            if(!StringUtils.isEmpty(oauthOauthClientToken.getUserUserName())){
                    criteria.andEqualTo("userUserName",oauthOauthClientToken.getUserUserName());
            }
            // 
            if(!StringUtils.isEmpty(oauthOauthClientToken.getClientClientId())){
                    criteria.andEqualTo("clientClientId",oauthOauthClientToken.getClientClientId());
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
        oauthOauthClientTokenMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改OauthOauthClientToken
     * @param oauthOauthClientToken
     */
    @Override
    public void update(OauthOauthClientToken oauthOauthClientToken){
        oauthOauthClientTokenMapper.updateByPrimaryKey(oauthOauthClientToken);
    }

    /**
     * 增加OauthOauthClientToken
     * @param oauthOauthClientToken
     */
    @Override
    public void add(OauthOauthClientToken oauthOauthClientToken){
        oauthOauthClientTokenMapper.insert(oauthOauthClientToken);
    }

    /**
     * 根据ID查询OauthOauthClientToken
     * @param id
     * @return
     */
    @Override
    public OauthOauthClientToken findById(String id){
        return  oauthOauthClientTokenMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询OauthOauthClientToken全部数据
     * @return
     */
    @Override
    public List<OauthOauthClientToken> findAll() {
        return oauthOauthClientTokenMapper.selectAll();
    }
}
