package com.order.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Table(name="tb_return_order_item")
public class ReturnReturnOrderItem implements Serializable{

	@Id
    @Column(name = "id")
	private String id;//ID

    @Column(name = "category_id")
	private Integer categoryCategoryId;//分类ID

    @Column(name = "spu_id")
	private String spuSpuId;//SPU_ID

    @Column(name = "sku_id")
	private String skuSkuId;//SKU_ID

    @Column(name = "order_id")
	private String orderOrderId;//订单ID

    @Column(name = "order_item_id")
	private String orderOrderItemId;//订单明细ID

    @Column(name = "return_order_id")
	private String returnReturnOrderId;//退货订单ID

    @Column(name = "title")
	private String title;//标题

    @Column(name = "price")
	private Integer price;//单价

    @Column(name = "num")
	private Integer num;//数量

    @Column(name = "money")
	private Integer money;//总金额

    @Column(name = "pay_money")
	private Integer payPayMoney;//支付金额

    @Column(name = "image")
	private String image;//图片地址

    @Column(name = "weight")
	private Integer weight;//重量



	//get方法
	public String getId() {
		return id;
	}

	//set方法
	public void setId(String id) {
		this.id = id;
	}
	//get方法
	public Integer getCategoryCategoryId() {
		return categoryCategoryId;
	}

	//set方法
	public void setCategoryCategoryId(Integer categoryCategoryId) {
		this.categoryCategoryId = categoryCategoryId;
	}
	//get方法
	public String getSpuSpuId() {
		return spuSpuId;
	}

	//set方法
	public void setSpuSpuId(String spuSpuId) {
		this.spuSpuId = spuSpuId;
	}
	//get方法
	public String getSkuSkuId() {
		return skuSkuId;
	}

	//set方法
	public void setSkuSkuId(String skuSkuId) {
		this.skuSkuId = skuSkuId;
	}
	//get方法
	public String getOrderOrderId() {
		return orderOrderId;
	}

	//set方法
	public void setOrderOrderId(String orderOrderId) {
		this.orderOrderId = orderOrderId;
	}
	//get方法
	public String getOrderOrderItemId() {
		return orderOrderItemId;
	}

	//set方法
	public void setOrderOrderItemId(String orderOrderItemId) {
		this.orderOrderItemId = orderOrderItemId;
	}
	//get方法
	public String getReturnReturnOrderId() {
		return returnReturnOrderId;
	}

	//set方法
	public void setReturnReturnOrderId(String returnReturnOrderId) {
		this.returnReturnOrderId = returnReturnOrderId;
	}
	//get方法
	public String getTitle() {
		return title;
	}

	//set方法
	public void setTitle(String title) {
		this.title = title;
	}
	//get方法
	public Integer getPrice() {
		return price;
	}

	//set方法
	public void setPrice(Integer price) {
		this.price = price;
	}
	//get方法
	public Integer getNum() {
		return num;
	}

	//set方法
	public void setNum(Integer num) {
		this.num = num;
	}
	//get方法
	public Integer getMoney() {
		return money;
	}

	//set方法
	public void setMoney(Integer money) {
		this.money = money;
	}
	//get方法
	public Integer getPayPayMoney() {
		return payPayMoney;
	}

	//set方法
	public void setPayPayMoney(Integer payPayMoney) {
		this.payPayMoney = payPayMoney;
	}
	//get方法
	public String getImage() {
		return image;
	}

	//set方法
	public void setImage(String image) {
		this.image = image;
	}
	//get方法
	public Integer getWeight() {
		return weight;
	}

	//set方法
	public void setWeight(Integer weight) {
		this.weight = weight;
	}


}
