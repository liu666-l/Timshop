package com.user.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Table(name="tb_stock_back")
public class StockStockBack implements Serializable{

    @Column(name = "order_id")
	private String orderOrderId;//订单id

	@Id
    @Column(name = "sku_id")
	private String skuSkuId;//SKU的id

    @Column(name = "num")
	private Integer num;//回滚数量

    @Column(name = "status")
	private String status;//回滚状态

    @Column(name = "create_time")
	private Date createCreateTime;//创建时间

    @Column(name = "back_time")
	private Date backBackTime;//回滚时间



	//get方法
	public String getOrderOrderId() {
		return orderOrderId;
	}

	//set方法
	public void setOrderOrderId(String orderOrderId) {
		this.orderOrderId = orderOrderId;
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
	public Integer getNum() {
		return num;
	}

	//set方法
	public void setNum(Integer num) {
		this.num = num;
	}
	//get方法
	public String getStatus() {
		return status;
	}

	//set方法
	public void setStatus(String status) {
		this.status = status;
	}
	//get方法
	public Date getCreateCreateTime() {
		return createCreateTime;
	}

	//set方法
	public void setCreateCreateTime(Date createCreateTime) {
		this.createCreateTime = createCreateTime;
	}
	//get方法
	public Date getBackBackTime() {
		return backBackTime;
	}

	//set方法
	public void setBackBackTime(Date backBackTime) {
		this.backBackTime = backBackTime;
	}


}
