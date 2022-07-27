package com.order.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name="tb_order_item")
public class OrderItem extends Order implements Serializable{
	private static final String serialVersionUID ="-1666385283077101254";

	@Id
    @Column(name = "id")
	private String id;//ID

    @Column(name = "category_id1")
	private Integer categoryId1;//1级分类

    @Column(name = "category_id2")
	private Integer categoryId2;//2级分类

    @Column(name = "category_id3")
	private Integer categoryId3;//3级分类

    @Column(name = "spu_id")
	private String SpuId;//SPU_ID

    @Column(name = "sku_id")
	private String SkuId;//SKU_ID

    @Column(name = "order_id")
	private String OrderId;//订单ID

    @Column(name = "name")
	private String name;//商品名称

    @Column(name = "price")
	private Integer price;//单价

    @Column(name = "num")
	private Integer num;//数量

    @Column(name = "money")
	private Integer money;//总金额

    @Column(name = "pay_money")
	private Integer payMoney;//实付金额

    @Column(name = "image")
	private String image;//图片地址

    @Column(name = "weight")
	private Integer weight;//重量

    @Column(name = "post_fee")
	private Integer postFee;//运费

    @Column(name = "is_return")
	private String isReturn;//是否退货
	private String orderId;

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	//get方法
	public String getId() {
		return id;
	}

	//set方法
	public void setId(String id) {
		this.id = id;
	}
	//get方法
	public Integer getCategoryCategoryId1() {
		return categoryId1;
	}

	//set方法
	public void setCategoryCategoryId1(Integer categoryCategoryId1) {
		this.categoryId1 = categoryCategoryId1;
	}
	//get方法
	public Integer getCategoryCategoryId2() {
		return categoryId2;
	}

	//set方法
	public void setCategoryCategoryId2(Integer categoryCategoryId2) {
		this.categoryId2 = categoryCategoryId2;
	}
	//get方法
	public Integer getCategoryCategoryId3() {
		return categoryId3;
	}

	//set方法
	public void setCategoryCategoryId3(Integer categoryCategoryId3) {
		this.categoryId3 = categoryCategoryId3;
	}
	//get方法
	public String getSpuSpuId() {
		return SpuId;
	}

	//set方法
	public void setSpuSpuId(String SpuId) {
		this.SpuId = SpuId;
	}
	//get方法
	public String getSkuSkuId() {
		return SkuId;
	}

	//set方法
	public void setSkuSkuId(String skuSkuId) {
		this.SkuId = skuSkuId;
	}
	//get方法
	public String getOrderOrderId() {
		return OrderId;
	}

	//set方法
	public void setOrderOrderId(String orderOrderId) {
		this.OrderId = orderOrderId;
	}
	//get方法
	public String getName() {
		return name;
	}

	//set方法
	public void setName(String name) {
		this.name = name;
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
		return payMoney;
	}

	//set方法
	public void setPayPayMoney(Integer payPayMoney) {
		this.payMoney = payPayMoney;
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
	public void setweight(Integer weight) {
		this.weight = weight;
	}
	//get方法
	public Integer getPostPostFee() {
		return postFee;
	}

	//set方法
	public void setPostPostFee(Integer postPostFee) {
		this.postFee = postPostFee;
	}
	//get方法
	public String getIsIsReturn() {
		return isReturn;
	}

	//set方法
	public void setIsReturn(String isIsReturn) {
		this.isReturn = isIsReturn;
	}

}
