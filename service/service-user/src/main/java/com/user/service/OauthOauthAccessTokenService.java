package com.user.service;

import com.user.pojo.OauthOauthAccessToken;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface OauthOauthAccessTokenService {

    /***
     * OauthOauthAccessToken多条件分页查询
     * @param oauthOauthAccessToken
     * @param page
     * @param size
     * @return
     */
    PageInfo<OauthOauthAccessToken> findPage(OauthOauthAccessToken oauthOauthAccessToken, int page, int size);

    /***
     * OauthOauthAccessToken分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OauthOauthAccessToken> findPage(int page, int size);

    /***
     * OauthOauthAccessToken多条件搜索方法
     * @param oauthOauthAccessToken
     * @return
     */
    List<OauthOauthAccessToken> findList(OauthOauthAccessToken oauthOauthAccessToken);

    /***
     * 删除OauthOauthAccessToken
     * @param id
     */
    void delete(String id);

    /***
     * 修改OauthOauthAccessToken数据
     * @param oauthOauthAccessToken
     */
    void update(OauthOauthAccessToken oauthOauthAccessToken);

    /***
     * 新增OauthOauthAccessToken
     * @param oauthOauthAccessToken
     */
    void add(OauthOauthAccessToken oauthOauthAccessToken);

    /**
     * 根据ID查询OauthOauthAccessToken
     * @param id
     * @return
     */
     OauthOauthAccessToken findById(String id);

    /***
     * 查询所有OauthOauthAccessToken
     * @return
     */
    List<OauthOauthAccessToken> findAll();
}
