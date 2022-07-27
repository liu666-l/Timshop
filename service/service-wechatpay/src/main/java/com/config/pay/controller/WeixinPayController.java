package com.config.pay.controller;

import com.alibaba.fastjson.JSON;
import com.config.pay.service.WeixinPayService;
import com.gitee.cardoon.wxpay.sdk.WXPayUtil;
import entity.Result;
import entity.StatusCode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.util.Map;

@RestController
@RequestMapping(value = "/weixin/pay")
public class WeixinPayController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private WeixinPayService weixinPayService;
    //创建支付二维码
    //普通订单：exchange.order，queue.order
    //秒杀订单：
    //exchange.seckillorder,queue.seckillorder
    @RequestMapping(value = "/create/native")
    public Result createNative(@RequestParam Map<String,String>parameterMap){
        Map<String,String> resultMap = weixinPayService.createnative(parameterMap);
        return new Result<>(true, StatusCode.OK,"创建二维码预付订单成功！",resultMap);
    }
    //状态查询
    @GetMapping(value = "/status/query")
    public Result queryStatus(String outtradeno){
      Map map= weixinPayService.querStatus(outtradeno);
      return new Result(true,StatusCode.OK,"查询成功",map);
    }
    //支付结果回调
    @RequestMapping(value = "/notify/url")
    public String notifyurl(HttpServletRequest request)throws Exception{
        ServletInputStream is=request.getInputStream();
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        byte[] buffer=new byte[1024];
        int len=0;
        while((len= is.read(buffer))!=-1){
            baos.write(buffer,0,len);
        }
        byte[] bytes=baos.toByteArray();
        String  xmlresult=new String(bytes,"UTF-8");
        Map<String, String> stringMap = WXPayUtil.xmlToMap(xmlresult);
        System.out.println(stringMap);
        //获取自定义数据
        String attach=stringMap.get("attach");
        Map<String,String> attachMap=JSON.parseObject(attach,Map.class);
        //发送支付结果给MQ
        rabbitTemplate.convertAndSend("exchange.order","queue.order", JSON.toJSONString(stringMap));
        String result="<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
        return result;
    }


}
