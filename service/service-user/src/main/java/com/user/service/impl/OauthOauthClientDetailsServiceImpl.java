package com.user.service.impl;

import com.user.dao.OauthOauthClientDetailsMapper;
import com.user.pojo.OauthOauthClientDetails;
import com.user.service.OauthOauthClientDetailsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class OauthOauthClientDetailsServiceImpl implements OauthOauthClientDetailsService {

    @Autowired
    private OauthOauthClientDetailsMapper oauthOauthClientDetailsMapper;


    /**
     * OauthOauthClientDetails条件+分页查询
     * @param oauthOauthClientDetails 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OauthOauthClientDetails> findPage(OauthOauthClientDetails oauthOauthClientDetails, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(oauthOauthClientDetails);
        //执行搜索
        return new PageInfo<OauthOauthClientDetails>(oauthOauthClientDetailsMapper.selectByExample(example));
    }

    /**
     * OauthOauthClientDetails分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OauthOauthClientDetails> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OauthOauthClientDetails>(oauthOauthClientDetailsMapper.selectAll());
    }

    /**
     * OauthOauthClientDetails条件查询
     * @param oauthOauthClientDetails
     * @return
     */
    @Override
    public List<OauthOauthClientDetails> findList(OauthOauthClientDetails oauthOauthClientDetails){
        //构建查询条件
        Example example = createExample(oauthOauthClientDetails);
        //根据构建的条件查询数据
        return oauthOauthClientDetailsMapper.selectByExample(example);
    }


    /**
     * OauthOauthClientDetails构建查询对象
     * @param oauthOauthClientDetails
     * @return
     */
    public Example createExample(OauthOauthClientDetails oauthOauthClientDetails){
        Example example=new Example(OauthOauthClientDetails.class);
        Example.Criteria criteria = example.createCriteria();
        if(oauthOauthClientDetails!=null){
            // 客户端ID，主要用于标识对应的应用
            if(!StringUtils.isEmpty(oauthOauthClientDetails.getClientClientId())){
                    criteria.andEqualTo("clientClientId",oauthOauthClientDetails.getClientClientId());
            }
            // 
            if(!StringUtils.isEmpty(oauthOauthClientDetails.getResourceResourceIds())){
                    criteria.andEqualTo("resourceResourceIds",oauthOauthClientDetails.getResourceResourceIds());
            }
            // 客户端秘钥，BCryptPasswordEncoder加密
            if(!StringUtils.isEmpty(oauthOauthClientDetails.getClientClientSecret())){
                    criteria.andEqualTo("clientClientSecret",oauthOauthClientDetails.getClientClientSecret());
            }
            // 对应的范围
            if(!StringUtils.isEmpty(oauthOauthClientDetails.getScope())){
                    criteria.andEqualTo("scope",oauthOauthClientDetails.getScope());
            }
            // 认证模式
            if(!StringUtils.isEmpty(oauthOauthClientDetails.getAuthorizedAuthorizedGrantTypes())){
                    criteria.andEqualTo("authorizedAuthorizedGrantTypes",oauthOauthClientDetails.getAuthorizedAuthorizedGrantTypes());
            }
            // 认证后重定向地址
            if(!StringUtils.isEmpty(oauthOauthClientDetails.getWebWebServerRedirectUri())){
                    criteria.andEqualTo("webWebServerRedirectUri",oauthOauthClientDetails.getWebWebServerRedirectUri());
            }
            // 
            if(!StringUtils.isEmpty(oauthOauthClientDetails.getAuthorities())){
                    criteria.andEqualTo("authorities",oauthOauthClientDetails.getAuthorities());
            }
            // 令牌有效期
            if(!StringUtils.isEmpty(oauthOauthClientDetails.getAccessAccessTokenValidity())){
                    criteria.andEqualTo("accessAccessTokenValidity",oauthOauthClientDetails.getAccessAccessTokenValidity());
            }
            // 令牌刷新周期
            if(!StringUtils.isEmpty(oauthOauthClientDetails.getRefreshRefreshTokenValidity())){
                    criteria.andEqualTo("refreshRefreshTokenValidity",oauthOauthClientDetails.getRefreshRefreshTokenValidity());
            }
            // 
            if(!StringUtils.isEmpty(oauthOauthClientDetails.getAdditionalAdditionalInformation())){
                    criteria.andEqualTo("additionalAdditionalInformation",oauthOauthClientDetails.getAdditionalAdditionalInformation());
            }
            // 
            if(!StringUtils.isEmpty(oauthOauthClientDetails.getAutoapprove())){
                    criteria.andEqualTo("autoapprove",oauthOauthClientDetails.getAutoapprove());
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
        oauthOauthClientDetailsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改OauthOauthClientDetails
     * @param oauthOauthClientDetails
     */
    @Override
    public void update(OauthOauthClientDetails oauthOauthClientDetails){
        oauthOauthClientDetailsMapper.updateByPrimaryKey(oauthOauthClientDetails);
    }

    /**
     * 增加OauthOauthClientDetails
     * @param oauthOauthClientDetails
     */
    @Override
    public void add(OauthOauthClientDetails oauthOauthClientDetails){
        oauthOauthClientDetailsMapper.insert(oauthOauthClientDetails);
    }

    /**
     * 根据ID查询OauthOauthClientDetails
     * @param id
     * @return
     */
    @Override
    public OauthOauthClientDetails findById(String id){
        return  oauthOauthClientDetailsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询OauthOauthClientDetails全部数据
     * @return
     */
    @Override
    public List<OauthOauthClientDetails> findAll() {
        return oauthOauthClientDetailsMapper.selectAll();
    }
}
