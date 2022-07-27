package com.user.service.impl;

import com.user.dao.OauthOauthAccessTokenMapper;
import com.user.pojo.OauthOauthAccessToken;
import com.user.service.OauthOauthAccessTokenService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class OauthOauthAccessTokenServiceImpl implements OauthOauthAccessTokenService {

    @Autowired
    private OauthOauthAccessTokenMapper oauthOauthAccessTokenMapper;


    /**
     * OauthOauthAccessToken条件+分页查询
     * @param oauthOauthAccessToken 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OauthOauthAccessToken> findPage(OauthOauthAccessToken oauthOauthAccessToken, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(oauthOauthAccessToken);
        //执行搜索
        return new PageInfo<OauthOauthAccessToken>(oauthOauthAccessTokenMapper.selectByExample(example));
    }

    /**
     * OauthOauthAccessToken分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OauthOauthAccessToken> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OauthOauthAccessToken>(oauthOauthAccessTokenMapper.selectAll());
    }

    /**
     * OauthOauthAccessToken条件查询
     * @param oauthOauthAccessToken
     * @return
     */
    @Override
    public List<OauthOauthAccessToken> findList(OauthOauthAccessToken oauthOauthAccessToken){
        //构建查询条件
        Example example = createExample(oauthOauthAccessToken);
        //根据构建的条件查询数据
        return oauthOauthAccessTokenMapper.selectByExample(example);
    }


    /**
     * OauthOauthAccessToken构建查询对象
     * @param oauthOauthAccessToken
     * @return
     */
    public Example createExample(OauthOauthAccessToken oauthOauthAccessToken){
        Example example=new Example(OauthOauthAccessToken.class);
        Example.Criteria criteria = example.createCriteria();
        if(oauthOauthAccessToken!=null){
            // 
            if(!StringUtils.isEmpty(oauthOauthAccessToken.getTokenTokenId())){
                    criteria.andEqualTo("tokenTokenId",oauthOauthAccessToken.getTokenTokenId());
            }
            // 
            if(!StringUtils.isEmpty(oauthOauthAccessToken.getToken())){
                    criteria.andEqualTo("token",oauthOauthAccessToken.getToken());
            }
            // 
            if(!StringUtils.isEmpty(oauthOauthAccessToken.getAuthenticationAuthenticationId())){
                    criteria.andEqualTo("authenticationAuthenticationId",oauthOauthAccessToken.getAuthenticationAuthenticationId());
            }
            // 
            if(!StringUtils.isEmpty(oauthOauthAccessToken.getUserUserName())){
                    criteria.andEqualTo("userUserName",oauthOauthAccessToken.getUserUserName());
            }
            // 
            if(!StringUtils.isEmpty(oauthOauthAccessToken.getClientClientId())){
                    criteria.andEqualTo("clientClientId",oauthOauthAccessToken.getClientClientId());
            }
            // 
            if(!StringUtils.isEmpty(oauthOauthAccessToken.getAuthentication())){
                    criteria.andEqualTo("authentication",oauthOauthAccessToken.getAuthentication());
            }
            // 
            if(!StringUtils.isEmpty(oauthOauthAccessToken.getRefreshRefreshToken())){
                    criteria.andEqualTo("refreshRefreshToken",oauthOauthAccessToken.getRefreshRefreshToken());
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
        oauthOauthAccessTokenMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改OauthOauthAccessToken
     * @param oauthOauthAccessToken
     */
    @Override
    public void update(OauthOauthAccessToken oauthOauthAccessToken){
        oauthOauthAccessTokenMapper.updateByPrimaryKey(oauthOauthAccessToken);
    }

    /**
     * 增加OauthOauthAccessToken
     * @param oauthOauthAccessToken
     */
    @Override
    public void add(OauthOauthAccessToken oauthOauthAccessToken){
        oauthOauthAccessTokenMapper.insert(oauthOauthAccessToken);
    }

    /**
     * 根据ID查询OauthOauthAccessToken
     * @param id
     * @return
     */
    @Override
    public OauthOauthAccessToken findById(String id){
        return  oauthOauthAccessTokenMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询OauthOauthAccessToken全部数据
     * @return
     */
    @Override
    public List<OauthOauthAccessToken> findAll() {
        return oauthOauthAccessTokenMapper.selectAll();
    }
}
