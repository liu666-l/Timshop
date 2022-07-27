package com.config.pay.service;

import java.util.Map;

public interface WeixinPayService {
    Map createnative(Map<String,String> prameterMap);
    //查讯订单状态
    Map querStatus(String outtradeno);
}
