package com.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Enumeration;

@Configuration
public class TokenRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        /**获取用户的令牌令牌
         * 将令牌在封装到头文件里
         */
        //记录当前用户请求的所有数据。
        ServletRequestAttributes requestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        /**
         * 获取请求头中的数据
         * 获取所有投中的名字
         */
        Enumeration<String> headerNames = requestAttributes.getRequest().getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headkey= headerNames.nextElement();
            String headerValue=requestAttributes.getRequest().getHeader(headkey);
            System.out.println(headkey+":"+headerValue);
            template.header(headkey,headerValue);
        }
    }
}
