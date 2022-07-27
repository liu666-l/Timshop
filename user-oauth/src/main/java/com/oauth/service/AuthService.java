package com.oauth.service;

import com.oauth.util.AuthToken;

public interface AuthService {
    AuthToken login(String username, String password, String clientId, String clientSecret);

}
