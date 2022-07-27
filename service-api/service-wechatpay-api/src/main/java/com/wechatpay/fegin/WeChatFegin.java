package com.wechatpay.fegin;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("wwchatpay")

public interface WeChatFegin {
}
