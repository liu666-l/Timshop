package com.order.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="undo_log")
public class UndoUndoLog implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//

    @Column(name = "branch_id")
	private Long branchBranchId;//

    @Column(name = "xid")
	private String xid;//

    @Column(name = "rollback_info")
	private String rollbackRollbackInfo;//

    @Column(name = "log_status")
	private Integer logLogStatus;//

    @Column(name = "log_created")
	private Date logLogCreated;//

    @Column(name = "log_modified")
	private Date logLogModified;//

    @Column(name = "ext")
	private String ext;//



	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
	}
	//get方法
	public Long getBranchBranchId() {
		return branchBranchId;
	}

	//set方法
	public void setBranchBranchId(Long branchBranchId) {
		this.branchBranchId = branchBranchId;
	}
	//get方法
	public String getXid() {
		return xid;
	}

	//set方法
	public void setXid(String xid) {
		this.xid = xid;
	}
	//get方法
	public String getRollbackRollbackInfo() {
		return rollbackRollbackInfo;
	}

	//set方法
	public void setRollbackRollbackInfo(String rollbackRollbackInfo) {
		this.rollbackRollbackInfo = rollbackRollbackInfo;
	}
	//get方法
	public Integer getLogLogStatus() {
		return logLogStatus;
	}

	//set方法
	public void setLogLogStatus(Integer logLogStatus) {
		this.logLogStatus = logLogStatus;
	}
	//get方法
	public Date getLogLogCreated() {
		return logLogCreated;
	}

	//set方法
	public void setLogLogCreated(Date logLogCreated) {
		this.logLogCreated = logLogCreated;
	}
	//get方法
	public Date getLogLogModified() {
		return logLogModified;
	}

	//set方法
	public void setLogLogModified(Date logLogModified) {
		this.logLogModified = logLogModified;
	}
	//get方法
	public String getExt() {
		return ext;
	}

	//set方法
	public void setExt(String ext) {
		this.ext = ext;
	}


}
