package com.order.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Table(name="tb_order_log")
public class OrderOrderLog implements Serializable{

	@Id
    @Column(name = "id")
	private String id;//ID

    @Column(name = "operater")
	private String operater;//操作员

    @Column(name = "operate_time")
	private Date operateOperateTime;//操作时间

    @Column(name = "order_id")
	private Long orderOrderId;//订单ID

    @Column(name = "order_status")
	private String orderOrderStatus;//订单状态

    @Column(name = "pay_status")
	private String payPayStatus;//付款状态

    @Column(name = "consign_status")
	private String consignConsignStatus;//发货状态

    @Column(name = "remarks")
	private String remarks;//备注



	//get方法
	public String getId() {
		return id;
	}

	//set方法
	public void setId(String id) {
		this.id = id;
	}
	//get方法
	public String getOperater() {
		return operater;
	}

	//set方法
	public void setOperater(String operater) {
		this.operater = operater;
	}
	//get方法
	public Date getOperateOperateTime() {
		return operateOperateTime;
	}

	//set方法
	public void setOperateOperateTime(Date operateOperateTime) {
		this.operateOperateTime = operateOperateTime;
	}
	//get方法
	public Long getOrderOrderId() {
		return orderOrderId;
	}

	//set方法
	public void setOrderOrderId(Long orderOrderId) {
		this.orderOrderId = orderOrderId;
	}
	//get方法
	public String getOrderOrderStatus() {
		return orderOrderStatus;
	}

	//set方法
	public void setOrderOrderStatus(String orderOrderStatus) {
		this.orderOrderStatus = orderOrderStatus;
	}
	//get方法
	public String getPayPayStatus() {
		return payPayStatus;
	}

	//set方法
	public void setPayPayStatus(String payPayStatus) {
		this.payPayStatus = payPayStatus;
	}
	//get方法
	public String getConsignConsignStatus() {
		return consignConsignStatus;
	}

	//set方法
	public void setConsignConsignStatus(String consignConsignStatus) {
		this.consignConsignStatus = consignConsignStatus;
	}
	//get方法
	public String getRemarks() {
		return remarks;
	}

	//set方法
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


}
