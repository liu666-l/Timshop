package com.order.service.impl;

import com.goods.feign.SkuFeign;
import com.goods.pojo.Sku;
import com.order.dao.OrderMapper;
import com.order.dao.OrderOrderItemMapper;
import com.order.pojo.Order;
import com.order.pojo.OrderItem;
import com.order.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import entity.IdWorker;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private RedisTemplate  redisTemplate;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderOrderItemMapper orderItemMapper;
    @Autowired
    private SkuFeign skuFeign;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void deleteOrder(String outtradeno) {
        Order order = orderMapper.selectByPrimaryKey(outtradeno);
        order.setUpdateUpdateTime(new Date());
        order.setPayPayStatus("2");
        orderMapper.updateByPrimaryKeySelective(order);
        //回滚库存
        List<OrderItem> orderItems = orderItemMapper.findByOrderId(order.getId());
        List<String> skuIds=new ArrayList<>();
        for (OrderItem orderItem: orderItems){
            skuIds.add(orderItem.getSkuSkuId());
        }
        List<Sku> skuList = skuFeign.findBySkuIds(order.getSkuIds()).getData();
        Map<Long, Sku> skuMap = skuList.stream().collect(Collectors.toMap(Sku::getId, a -> a));
        for (OrderItem orderItem:orderItems){
            Sku sku=skuMap.get(orderItem.getSkuSkuId());
            sku.setNum(sku.getNum()+orderItem.getNum());
        }
        skuFeign.updateMap(skuMap);
    }

    /**
     * 修改订单状态
     * @param outtradeno
     * @param pattime
     * @param transactionid
     */
    @Override
    public void updateStatus(String outtradeno, String pattime, String transactionid) throws ParseException {
        //时间转换
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = simpleDateFormat.parse(pattime);

        Order order = orderMapper.selectByPrimaryKey(outtradeno);
        order.setPayPayTime(date);
        order.setPayPayStatus("1");
        order.setTransactionTransactionId(transactionid);
        orderMapper.updateByPrimaryKeySelective(order);
    }

    /**
     * Order条件+分页查询
     * @param order 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Order> findPage(Order order, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(order);
        //执行搜索
        return new PageInfo<Order>(orderMapper.selectByExample(example));
    }

    /**
     * Order分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Order> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Order>(orderMapper.selectAll());
    }

    /**
     * Order条件查询
     * @param order
     * @return
     */
    @Override
    public List<Order> findList(Order order){
        //构建查询条件
        Example example = createExample(order);
        //根据构建的条件查询数据
        return orderMapper.selectByExample(example);
    }


    /**
     * Order构建查询对象
     * @param order
     * @return
     */
    public Example createExample(Order order){
        Example example=new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        if(order!=null){
            // 订单id
            if(!StringUtils.isEmpty(order.getId())){
                    criteria.andEqualTo("id",order.getId());
            }
            // 数量合计
            if(!StringUtils.isEmpty(order.getTotalTotalNum())){
                    criteria.andEqualTo("totalTotalNum",order.getTotalTotalNum());
            }
            // 金额合计
            if(!StringUtils.isEmpty(order.getTotalTotalMoney())){
                    criteria.andEqualTo("totalTotalMoney",order.getTotalTotalMoney());
            }
            // 优惠金额
            if(!StringUtils.isEmpty(order.getPrePreMoney())){
                    criteria.andEqualTo("prePreMoney",order.getPrePreMoney());
            }
            // 邮费
            if(!StringUtils.isEmpty(order.getPostPostFee())){
                    criteria.andEqualTo("postPostFee",order.getPostPostFee());
            }
            // 实付金额
            if(!StringUtils.isEmpty(order.getPayPayMoney())){
                    criteria.andEqualTo("payPayMoney",order.getPayPayMoney());
            }
            // 支付类型，1、在线支付、0 货到付款
            if(!StringUtils.isEmpty(order.getPayPayType())){
                    criteria.andEqualTo("payPayType",order.getPayPayType());
            }
            // 订单创建时间
            if(!StringUtils.isEmpty(order.getCreateCreateTime())){
                    criteria.andEqualTo("createCreateTime",order.getCreateCreateTime());
            }
            // 订单更新时间
            if(!StringUtils.isEmpty(order.getUpdateUpdateTime())){
                    criteria.andEqualTo("updateUpdateTime",order.getUpdateUpdateTime());
            }
            // 付款时间
            if(!StringUtils.isEmpty(order.getPayPayTime())){
                    criteria.andEqualTo("payPayTime",order.getPayPayTime());
            }
            // 发货时间
            if(!StringUtils.isEmpty(order.getConsignConsignTime())){
                    criteria.andEqualTo("consignConsignTime",order.getConsignConsignTime());
            }
            // 交易完成时间
            if(!StringUtils.isEmpty(order.getEndEndTime())){
                    criteria.andEqualTo("endEndTime",order.getEndEndTime());
            }
            // 交易关闭时间
            if(!StringUtils.isEmpty(order.getCloseCloseTime())){
                    criteria.andEqualTo("closeCloseTime",order.getCloseCloseTime());
            }
            // 物流名称
            if(!StringUtils.isEmpty(order.getShippingShippingName())){
                    criteria.andEqualTo("shippingShippingName",order.getShippingShippingName());
            }
            // 物流单号
            if(!StringUtils.isEmpty(order.getShippingShippingCode())){
                    criteria.andEqualTo("shippingShippingCode",order.getShippingShippingCode());
            }
            // 用户名称
            if(!StringUtils.isEmpty(order.getUsername())){
                    criteria.andLike("username","%"+order.getUsername()+"%");
            }
            // 买家留言
            if(!StringUtils.isEmpty(order.getBuyerBuyerMessage())){
                    criteria.andEqualTo("buyerBuyerMessage",order.getBuyerBuyerMessage());
            }
            // 是否评价
            if(!StringUtils.isEmpty(order.getBuyerBuyerRate())){
                    criteria.andEqualTo("buyerBuyerRate",order.getBuyerBuyerRate());
            }
            // 收货人
            if(!StringUtils.isEmpty(order.getReceiverReceiverContact())){
                    criteria.andEqualTo("receiverReceiverContact",order.getReceiverReceiverContact());
            }
            // 收货人手机
            if(!StringUtils.isEmpty(order.getReceiverReceiverMobile())){
                    criteria.andEqualTo("receiverReceiverMobile",order.getReceiverReceiverMobile());
            }
            // 收货人地址
            if(!StringUtils.isEmpty(order.getReceiverReceiverAddress())){
                    criteria.andEqualTo("receiverReceiverAddress",order.getReceiverReceiverAddress());
            }
            // 订单来源：1:web，2：app，3：微信公众号，4：微信小程序  5 H5手机页面
            if(!StringUtils.isEmpty(order.getSourceSourceType())){
                    criteria.andEqualTo("sourceSourceType",order.getSourceSourceType());
            }
            // 交易流水号
            if(!StringUtils.isEmpty(order.getTransactionTransactionId())){
                    criteria.andEqualTo("transactionTransactionId",order.getTransactionTransactionId());
            }
            // 订单状态 
            if(!StringUtils.isEmpty(order.getOrderOrderStatus())){
                    criteria.andEqualTo("orderOrderStatus",order.getOrderOrderStatus());
            }
            // 支付状态 0:未支付 1:已支付
            if(!StringUtils.isEmpty(order.getPayPayStatus())){
                    criteria.andEqualTo("payPayStatus",order.getPayPayStatus());
            }
            // 发货状态 0:未发货 1:已发货 2:已送达
            if(!StringUtils.isEmpty(order.getConsignConsignStatus())){
                    criteria.andEqualTo("consignConsignStatus",order.getConsignConsignStatus());
            }
            // 是否删除
            if(!StringUtils.isEmpty(order.getIsIsDelete())){
                    criteria.andEqualTo("isIsDelete",order.getIsIsDelete());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(String id){
        orderMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Order
     * @param order
     */
    @Override
    public void update(Order order){
        orderMapper.updateByPrimaryKey(order);
    }

    /**
     * 增加Order
     * @param order
     */
    @Override
    public void add(Order order){
        order.setId(String.valueOf(idWorker.nextId()));
        BoundHashOperations boundHashOperations = redisTemplate.boundHashOps("Cart_" + order.getUsername());
        int totalNum=0,totalMoney=0;    //总数量，总金额
        LocalDateTime localDateTime = LocalDateTime.now();
        List<OrderItem> orderItems = boundHashOperations.values();   //从购物车中获取订单明细
        if (orderItems == null || orderItems.size()==0) {
            throw new RuntimeException("购物车数据异常,下单失败");
        }
        List<Sku> skuList = skuFeign.findBySkuIds(order.getSkuIds()).getData(); //数据库中对应的sku集合
        //如果数据库中查询出来的sku集合数量与前端传过来的sku数量不一致，说明数据有误，下单失败
        if (skuList.size() != order.getSkuIds().size()){
            throw new RuntimeException("sku数据库数据异常,下单失败");
        }
        Map<Long,Sku> skuMap = skuList.stream().collect(Collectors.toMap(Sku::getId,a -> a));
        //遍历购物车中的数据，判断是否是选中的，将选中的订单明细数据补充完整
        for (OrderItem orderItem : orderItems) {
            if (order.getSkuIds().contains(orderItem.getSkuSkuId())) {     //判断当前遍历到的orderItem是否是选中的
                orderItem.setId(String.valueOf(idWorker.nextId()));
                orderItem.setOrderOrderId(order.getId());
                orderItem.setIsReturn("0");
                Sku sku = skuMap.get(orderItem.getSkuSkuId()); //数据库中的sku
                if (orderItem.getNum() <= sku.getNum()) {   //判断库存是否充足，不足则报异常订单提交失败
                    totalNum += orderItem.getNum();
                } else {
                    throw new RuntimeException("库存不足,下单失败");
                }
                totalMoney += sku.getPrice();
            }
        }
        //减库存，删购物车
        for (OrderItem orderItem : orderItems) {
            if (order.getSkuIds().contains(orderItem.getSkuSkuId())) {
                Sku sku = skuMap.get(orderItem.getSkuSkuId()); //数据库中的sku
                sku.setNum(sku.getNum() - orderItem.getNum()); //减库存
                boundHashOperations.delete(orderItem.getSkuSkuId()); //删购物车
                orderItemMapper.insertSelective(orderItem); //添加到订单明细表
            }
        }
        skuFeign.updateMap(skuMap); //将sku信息提交到数据库中的sku表

        order.setCreateCreateTime(new Date());
        order.setUpdateUpdateTime(new Date());
        order.setTotalTotalNum(totalNum);
        order.setTotalTotalMoney(totalMoney);
        order.setSourceSourceType("1");   //1.web
        order.setOrderOrderStatus("0");
        order.setPayPayStatus("0");
        order.setIsIsDelete("0");
        orderMapper.insertSelective(order); //添加到订单表

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("创建时间"+simpleDateFormat.format(new Date()));
        rabbitTemplate.convertAndSend("orderListenerQueue", (Object) order.getId(), new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration("10000");
                return null;
            }
        });
    }

    /**
     * 根据ID查询Order
     * @param id
     * @return
     */
    @Override
    public Order findById(String id){
        return  orderMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Order全部数据
     * @return
     */
    @Override
    public List<Order> findAll() {
        return orderMapper.selectAll();
    }
}
