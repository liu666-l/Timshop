package com.user.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Table(name="tb_point_log")
public class PointPointLog implements Serializable{

	@Id
    @Column(name = "order_id")
	private String orderOrderId;//

    @Column(name = "user_id")
	private String userUserId;//

    @Column(name = "point")
	private Integer point;//



	//get方法
	public String getOrderOrderId() {
		return orderOrderId;
	}

	//set方法
	public void setOrderOrderId(String orderOrderId) {
		this.orderOrderId = orderOrderId;
	}
	//get方法
	public String getUserUserId() {
		return userUserId;
	}

	//set方法
	public void setUserUserId(String userUserId) {
		this.userUserId = userUserId;
	}
	//get方法
	public Integer getPoint() {
		return point;
	}

	//set方法
	public void setPoint(Integer point) {
		this.point = point;
	}


}
