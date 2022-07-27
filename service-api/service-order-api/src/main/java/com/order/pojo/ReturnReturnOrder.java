package com.order.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name="tb_return_order")
public class ReturnReturnOrder implements Serializable{

	@Id
    @Column(name = "id")
	private String id;//服务单号

    @Column(name = "order_id")
	private Long orderOrderId;//订单号

    @Column(name = "apply_time")
	private Date applyApplyTime;//申请时间

    @Column(name = "user_id")
	private Long userUserId;//用户ID

    @Column(name = "user_account")
	private String userUserAccount;//用户账号

    @Column(name = "linkman")
	private String linkman;//联系人

    @Column(name = "linkman_mobile")
	private String linkmanLinkmanMobile;//联系人手机

    @Column(name = "type")
	private String type;//类型

    @Column(name = "return_money")
	private Integer returnReturnMoney;//退款金额

    @Column(name = "is_return_freight")
	private String isIsReturnFreight;//是否退运费

    @Column(name = "status")
	private String status;//申请状态

    @Column(name = "dispose_time")
	private Date disposeDisposeTime;//处理时间

    @Column(name = "return_cause")
	private Integer returnReturnCause;//退货退款原因

    @Column(name = "evidence")
	private String evidence;//凭证图片

    @Column(name = "description")
	private String description;//问题描述

    @Column(name = "remark")
	private String remark;//处理备注

    @Column(name = "admin_id")
	private Integer adminAdminId;//管理员id



	//get方法
	public String getId() {
		return id;
	}

	//set方法
	public void setId(String id) {
		this.id = id;
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
	public Date getApplyApplyTime() {
		return applyApplyTime;
	}

	//set方法
	public void setApplyApplyTime(Date applyApplyTime) {
		this.applyApplyTime = applyApplyTime;
	}
	//get方法
	public Long getUserUserId() {
		return userUserId;
	}

	//set方法
	public void setUserUserId(Long userUserId) {
		this.userUserId = userUserId;
	}
	//get方法
	public String getUserUserAccount() {
		return userUserAccount;
	}

	//set方法
	public void setUserUserAccount(String userUserAccount) {
		this.userUserAccount = userUserAccount;
	}
	//get方法
	public String getLinkman() {
		return linkman;
	}

	//set方法
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	//get方法
	public String getLinkmanLinkmanMobile() {
		return linkmanLinkmanMobile;
	}

	//set方法
	public void setLinkmanLinkmanMobile(String linkmanLinkmanMobile) {
		this.linkmanLinkmanMobile = linkmanLinkmanMobile;
	}
	//get方法
	public String getType() {
		return type;
	}

	//set方法
	public void setType(String type) {
		this.type = type;
	}
	//get方法
	public Integer getReturnReturnMoney() {
		return returnReturnMoney;
	}

	//set方法
	public void setReturnReturnMoney(Integer returnReturnMoney) {
		this.returnReturnMoney = returnReturnMoney;
	}
	//get方法
	public String getIsIsReturnFreight() {
		return isIsReturnFreight;
	}

	//set方法
	public void setIsIsReturnFreight(String isIsReturnFreight) {
		this.isIsReturnFreight = isIsReturnFreight;
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
	public Date getDisposeDisposeTime() {
		return disposeDisposeTime;
	}

	//set方法
	public void setDisposeDisposeTime(Date disposeDisposeTime) {
		this.disposeDisposeTime = disposeDisposeTime;
	}
	//get方法
	public Integer getReturnReturnCause() {
		return returnReturnCause;
	}

	//set方法
	public void setReturnReturnCause(Integer returnReturnCause) {
		this.returnReturnCause = returnReturnCause;
	}
	//get方法
	public String getEvidence() {
		return evidence;
	}

	//set方法
	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}
	//get方法
	public String getDescription() {
		return description;
	}

	//set方法
	public void setDescription(String description) {
		this.description = description;
	}
	//get方法
	public String getRemark() {
		return remark;
	}

	//set方法
	public void setRemark(String remark) {
		this.remark = remark;
	}
	//get方法
	public Integer getAdminAdminId() {
		return adminAdminId;
	}

	//set方法
	public void setAdminAdminId(Integer adminAdminId) {
		this.adminAdminId = adminAdminId;
	}


}
