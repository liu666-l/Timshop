package com.user.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="tb_pref")
public class Pref implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//ID

    @Column(name = "cate_id")
	private Integer cateCateId;//分类ID

    @Column(name = "buy_money")
	private Integer buyBuyMoney;//消费金额

    @Column(name = "pre_money")
	private Integer prePreMoney;//优惠金额

    @Column(name = "start_time")
	private Date startStartTime;//活动开始日期

    @Column(name = "end_time")
	private Date endEndTime;//活动截至日期

    @Column(name = "type")
	private String type;//类型,1:普通订单，2：限时活动

    @Column(name = "state")
	private String state;//状态,1:有效，0：无效



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public Integer getCateCateId() {
		return cateCateId;
	}

	//set方法
	public void setCateCateId(Integer cateCateId) {
		this.cateCateId = cateCateId;
	}
	//get方法
	public Integer getBuyBuyMoney() {
		return buyBuyMoney;
	}

	//set方法
	public void setBuyBuyMoney(Integer buyBuyMoney) {
		this.buyBuyMoney = buyBuyMoney;
	}
	//get方法
	public Integer getPrePreMoney() {
		return prePreMoney;
	}

	//set方法
	public void setPrePreMoney(Integer prePreMoney) {
		this.prePreMoney = prePreMoney;
	}
	//get方法
	public Date getStartStartTime() {
		return startStartTime;
	}

	//set方法
	public void setStartStartTime(Date startStartTime) {
		this.startStartTime = startStartTime;
	}
	//get方法
	public Date getEndEndTime() {
		return endEndTime;
	}

	//set方法
	public void setEndEndTime(Date endEndTime) {
		this.endEndTime = endEndTime;
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
	public String getState() {
		return state;
	}

	//set方法
	public void setState(String state) {
		this.state = state;
	}


}
