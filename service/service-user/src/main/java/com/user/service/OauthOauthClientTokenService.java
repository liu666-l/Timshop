package com.user.service;

import com.user.pojo.OauthOauthClientToken;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface OauthOauthClientTokenService {

    /***
     * OauthOauthClientToken多条件分页查询
     * @param oauthOauthClientToken
     * @param page
     * @param size
     * @return
     */
    PageInfo<OauthOauthClientToken> findPage(OauthOauthClientToken oauthOauthClientToken, int page, int size);

    /***
     * OauthOauthClientToken分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OauthOauthClientToken> findPage(int page, int size);

    /***
     * OauthOauthClientToken多条件搜索方法
     * @param oauthOauthClientToken
     * @return
     */
    List<OauthOauthClientToken> findList(OauthOauthClientToken oauthOauthClientToken);

    /***
     * 删除OauthOauthClientToken
     * @param id
     */
    void delete(String id);

    /***
     * 修改OauthOauthClientToken数据
     * @param oauthOauthClientToken
     */
    void update(OauthOauthClientToken oauthOauthClientToken);

    /***
     * 新增OauthOauthClientToken
     * @param oauthOauthClientToken
     */
    void add(OauthOauthClientToken oauthOauthClientToken);

    /**
     * 根据ID查询OauthOauthClientToken
     * @param id
     * @return
     */
     OauthOauthClientToken findById(String id);

    /***
     * 查询所有OauthOauthClientToken
     * @return
     */
    List<OauthOauthClientToken> findAll();
}
