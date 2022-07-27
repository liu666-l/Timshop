package com.order.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="tb_task")
public class Task implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//任务id

    @Column(name = "create_time")
	private Date createCreateTime;//

    @Column(name = "update_time")
	private Date updateUpdateTime;//

    @Column(name = "delete_time")
	private Date deleteDeleteTime;//

    @Column(name = "task_type")
	private String taskTaskType;//任务类型

    @Column(name = "mq_exchange")
	private String mqMqExchange;//交换机名称

    @Column(name = "mq_routingkey")
	private String mqMqRoutingkey;//routingkey

    @Column(name = "request_body")
	private String requestRequestBody;//任务请求的内容

    @Column(name = "status")
	private String status;//任务状态

    @Column(name = "errormsg")
	private String errormsg;//任务错误信息



	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
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
	public Date getUpdateUpdateTime() {
		return updateUpdateTime;
	}

	//set方法
	public void setUpdateUpdateTime(Date updateUpdateTime) {
		this.updateUpdateTime = updateUpdateTime;
	}
	//get方法
	public Date getDeleteDeleteTime() {
		return deleteDeleteTime;
	}

	//set方法
	public void setDeleteDeleteTime(Date deleteDeleteTime) {
		this.deleteDeleteTime = deleteDeleteTime;
	}
	//get方法
	public String getTaskTaskType() {
		return taskTaskType;
	}

	//set方法
	public void setTaskTaskType(String taskTaskType) {
		this.taskTaskType = taskTaskType;
	}
	//get方法
	public String getMqMqExchange() {
		return mqMqExchange;
	}

	//set方法
	public void setMqMqExchange(String mqMqExchange) {
		this.mqMqExchange = mqMqExchange;
	}
	//get方法
	public String getMqMqRoutingkey() {
		return mqMqRoutingkey;
	}

	//set方法
	public void setMqMqRoutingkey(String mqMqRoutingkey) {
		this.mqMqRoutingkey = mqMqRoutingkey;
	}
	//get方法
	public String getRequestRequestBody() {
		return requestRequestBody;
	}

	//set方法
	public void setRequestRequestBody(String requestRequestBody) {
		this.requestRequestBody = requestRequestBody;
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
	public String getErrormsg() {
		return errormsg;
	}

	//set方法
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}


}
