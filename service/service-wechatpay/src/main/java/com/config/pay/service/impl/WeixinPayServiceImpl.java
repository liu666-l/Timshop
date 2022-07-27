package com.config.pay.service.impl;

import com.alibaba.fastjson.JSON;
import com.config.pay.service.WeixinPayService;
import com.gitee.cardoon.wxpay.sdk.WXPayUtil;
import entity.HttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeixinPayServiceImpl implements WeixinPayService {
    @Value("${wechat.appid}")
    private String appid;
    //商户号
    @Value("${wechat.mch_id}")
    private String partner;
    //秘钥
    @Value("${wechat.key}")
    private String partnerkey;
    //支付回调网址
    @Value("${wechat.notify_url}")
    private String notifyurl;
    public Map createnative(Map<String, String> prameterMap) {
       Map<String,String> paramMap=new HashMap<String,String>();
        paramMap.put("appid",appid);
        paramMap.put("mch_id",partner);
        //随机字符
        paramMap.put("nonce_str", WXPayUtil.generateNonceStr());
        paramMap.put("body","畅购商品");
        paramMap.put("out_trade_no",prameterMap.get("outtradeno"));
        paramMap.put("total_fee",prameterMap.get("totalfee"));
        paramMap.put("spbill_create_ip","127.0.0.1");
        paramMap.put("notify_url",notifyurl);
        paramMap.put("trade_type","NATIVE");
        try {
            //获取自定义数据
            String exchange=paramMap.get("exchange");
            String rountingkey=paramMap.get("routingkey");
            Map<String,String> attchMap=new HashMap<String,String>();
            attchMap.put("exchange",exchange);
            attchMap.put("routingkey",rountingkey);
            String username=paramMap.get("username");
            if(!StringUtils.isEmpty(username)){
                attchMap.put("username",username);
            }
            String attch= JSON.toJSONString(attchMap);
            paramMap.put("atach",attch);

            String xmlparameters=WXPayUtil.generateSignedXml(paramMap,partnerkey);
            String url="https://api.mch.weixin.qq.com/pay/unifiedorder";
            HttpClient httpClient=new HttpClient(url);
            httpClient.setHttps(true);
            httpClient.setXmlParam(xmlparameters);
            httpClient.post();;
            //获取返回数据
            String result= httpClient.getContent();
            //返回数据转换成MAP
            Map<String,String> resultMap=WXPayUtil.xmlToMap(result);
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
    //查询状态
    @Override
    public Map querStatus(String outtradeno) {
        Map<String,String> paramMap=new HashMap<String,String>();
        paramMap.put("appid",appid);
        paramMap.put("mch_id",partner);
        //随机字符
        paramMap.put("nonce_str", WXPayUtil.generateNonceStr());
        paramMap.put("out_trade_no",outtradeno);
        try {
            String xmlparameters=WXPayUtil.generateSignedXml(paramMap,partnerkey);
            String url="https://api.mch.weixin.qq.com/pay/orderquery";
            HttpClient httpClient=new HttpClient(url);
            httpClient.setHttps(true);
            httpClient.setXmlParam(xmlparameters);
            httpClient.post();;
            //获取返回数据
            String result= httpClient.getContent();
            //返回数据转换成MAP
            Map<String,String> resultMap=WXPayUtil.xmlToMap(result);
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
