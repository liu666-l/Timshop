package com.order.service.impl;

import com.goods.feign.SkuFeign;
import com.goods.feign.SpuFeign;
import com.goods.pojo.Sku;
import com.goods.pojo.Spu;
import com.order.pojo.OrderItem;
import com.order.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    SkuFeign skuFeign;
    @Autowired
    SpuFeign spuFeign;
    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public void add(Integer num, String id,String username) {
        BoundHashOperations boundHashOperations = redisTemplate.boundHashOps("Cart_" + username);
        if (num <= 0){
            boundHashOperations.delete(id);
            Long size = boundHashOperations.size();
            if (size == null || size<=0) {
                redisTemplate.delete("Cart_" + username);
            }
            return;
        }
        Sku sku = skuFeign.findById(id).getData();
        if (sku == null) {
            throw new RuntimeException("未查询到商品信息");
        }
        Spu spu = spuFeign.findbyId(sku.getSpuId()).getData();
        if (spu == null) {
            throw new RuntimeException("数据库中数据异常");
        }
        OrderItem orderItem = getOrderOrderItem(num,sku,spu);
        boundHashOperations.put(id,orderItem);


    }
    /*
    购物车集合查询
     */
    @Override
    public List<OrderItem> list(String username) {
        return redisTemplate.boundHashOps("Cart_"+username).values();
    }

    //创建一个orderitem 对象
    private OrderItem getOrderOrderItem(Integer num, Sku sku, Spu spu) {
        OrderItem orderItem=new OrderItem();
        orderItem.setCategoryCategoryId1(spu.getCategory1Id());
        orderItem.setCategoryCategoryId2(spu.getCategory2Id());
        orderItem.setCategoryCategoryId3(spu.getCategory3Id());
        orderItem.setSkuSkuId(sku.getId().toString());
        orderItem.setSpuSpuId(spu.getId().toString());
        orderItem.setName(sku.getName());
        orderItem.setPrice(sku.getPrice());
        orderItem.setNum(num);
        orderItem.setImage(spu.getImage());
        orderItem.setMoney(num *orderItem.getPrice());
        return orderItem;
    }
}
