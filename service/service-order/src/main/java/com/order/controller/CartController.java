package com.order.controller;

import com.order.pojo.OrderItem;
import com.order.service.CartService;
import com.order.util.TokenDecodeUtil;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cart")
@CrossOrigin
public class CartController {
    @Autowired
    private TokenDecodeUtil tokenDecodeUtil;
    @Autowired
    private CartService cartService;
    @GetMapping(value = "/add")
    public Result add( Integer num, String id){
        String username=tokenDecodeUtil.getUserInfo().get("username");
        cartService.add(num,id,username);
        return new Result(true, StatusCode.OK,"加入购物车成功");

    }
    @GetMapping(value = "/list")
    public Result<List<OrderItem>> list(){
        String username=tokenDecodeUtil.getUserInfo().get("username");
        List<OrderItem> orderItems=cartService.list(username);
        return new Result<List<OrderItem>>(true,StatusCode.OK,"查询购物车成功",orderItems);
    }
 }

