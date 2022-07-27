package com.oauth.interceptor;

import com.oauth.util.AdminToken;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        //生成令牌
        String token= com.changgou.oauth.util.AdminToken.admintoken();
        template.header("Authorization","bearer"+token);
    }
}
