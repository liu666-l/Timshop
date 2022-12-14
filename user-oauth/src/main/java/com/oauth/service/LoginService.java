package com.oauth.service;
import com.oauth.util.AuthToken;


public interface LoginService {
    /**
     * 模拟用户的行为 发送请求 申请令牌 返回
     * @param username
     * @param password
     * @param clientId
     * @param clientSecret
     * @param grantType
     * @return
     */
    AuthToken login(String username, String password, String clientId, String clientSecret, String grantType);

}
