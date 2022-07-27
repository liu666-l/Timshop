package com.user.service;

import com.user.pojo.OauthOauthClientDetails;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface OauthOauthClientDetailsService {

    /***
     * OauthOauthClientDetails多条件分页查询
     * @param oauthOauthClientDetails
     * @param page
     * @param size
     * @return
     */
    PageInfo<OauthOauthClientDetails> findPage(OauthOauthClientDetails oauthOauthClientDetails, int page, int size);

    /***
     * OauthOauthClientDetails分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OauthOauthClientDetails> findPage(int page, int size);

    /***
     * OauthOauthClientDetails多条件搜索方法
     * @param oauthOauthClientDetails
     * @return
     */
    List<OauthOauthClientDetails> findList(OauthOauthClientDetails oauthOauthClientDetails);

    /***
     * 删除OauthOauthClientDetails
     * @param id
     */
    void delete(String id);

    /***
     * 修改OauthOauthClientDetails数据
     * @param oauthOauthClientDetails
     */
    void update(OauthOauthClientDetails oauthOauthClientDetails);

    /***
     * 新增OauthOauthClientDetails
     * @param oauthOauthClientDetails
     */
    void add(OauthOauthClientDetails oauthOauthClientDetails);

    /**
     * 根据ID查询OauthOauthClientDetails
     * @param id
     * @return
     */
     OauthOauthClientDetails findById(String id);

    /***
     * 查询所有OauthOauthClientDetails
     * @return
     */
    List<OauthOauthClientDetails> findAll();
}
