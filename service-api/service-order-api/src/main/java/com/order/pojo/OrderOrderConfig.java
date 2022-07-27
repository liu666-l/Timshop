package com.order.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Table(name="tb_order_config")
public class OrderOrderConfig implements Serializable{

	@Id
    @Column(name = "id")
	private Integer id;//ID

    @Column(name = "order_timeout")
	private Integer orderOrderTimeout;//正常订单超时时间（分）

    @Column(name = "seckill_timeout")
	private Integer seckillSeckillTimeout;//秒杀订单超时时间（分）

    @Column(name = "take_timeout")
	private Integer takeTakeTimeout;//自动收货（天）

    @Column(name = "service_timeout")
	private Integer serviceServiceTimeout;//售后期限

    @Column(name = "comment_timeout")
	private Integer commentCommentTimeout;//自动五星好评



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public Integer getOrderOrderTimeout() {
		return orderOrderTimeout;
	}

	//set方法
	public void setOrderOrderTimeout(Integer orderOrderTimeout) {
		this.orderOrderTimeout = orderOrderTimeout;
	}
	//get方法
	public Integer getSeckillSeckillTimeout() {
		return seckillSeckillTimeout;
	}

	//set方法
	public void setSeckillSeckillTimeout(Integer seckillSeckillTimeout) {
		this.seckillSeckillTimeout = seckillSeckillTimeout;
	}
	//get方法
	public Integer getTakeTakeTimeout() {
		return takeTakeTimeout;
	}

	//set方法
	public void setTakeTakeTimeout(Integer takeTakeTimeout) {
		this.takeTakeTimeout = takeTakeTimeout;
	}
	//get方法
	public Integer getServiceServiceTimeout() {
		return serviceServiceTimeout;
	}

	//set方法
	public void setServiceServiceTimeout(Integer serviceServiceTimeout) {
		this.serviceServiceTimeout = serviceServiceTimeout;
	}
	//get方法
	public Integer getCommentCommentTimeout() {
		return commentCommentTimeout;
	}

	//set方法
	public void setCommentCommentTimeout(Integer commentCommentTimeout) {
		this.commentCommentTimeout = commentCommentTimeout;
	}


}
