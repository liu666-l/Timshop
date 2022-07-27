package com.user.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Table(name="tb_user")
public class User implements Serializable{

	@Id
    @Column(name = "username")
	private String username;//用户名

    @Column(name = "password")
	private String password;//密码，加密存储

    @Column(name = "phone")
	private String phone;//注册手机号

    @Column(name = "email")
	private String email;//注册邮箱

    @Column(name = "created")
	private Date created;//创建时间

    @Column(name = "updated")
	private Date updated;//修改时间

    @Column(name = "source_type")
	private String sourceSourceType;//会员来源：1:PC，2：H5，3：Android，4：IOS

    @Column(name = "nick_name")
	private String nickNickName;//昵称

    @Column(name = "name")
	private String name;//真实姓名

    @Column(name = "status")
	private String status;//使用状态（1正常 0非正常）

    @Column(name = "head_pic")
	private String headHeadPic;//头像地址

    @Column(name = "qq")
	private String qq;//QQ号码

    @Column(name = "is_mobile_check")
	private String isIsMobileCheck;//手机是否验证 （0否  1是）

    @Column(name = "is_email_check")
	private String isIsEmailCheck;//邮箱是否检测（0否  1是）

    @Column(name = "sex")
	private String sex;//性别，1男，0女

    @Column(name = "user_level")
	private Integer userUserLevel;//会员等级

    @Column(name = "points")
	private Integer points;//积分

    @Column(name = "experience_value")
	private Integer experienceExperienceValue;//经验值

    @Column(name = "birthday")
	private Date birthday;//出生年月日

    @Column(name = "last_login_time")
	private Date lastLastLoginTime;//最后登录时间



	//get方法
	public String getUsername() {
		return username;
	}

	//set方法
	public void setUsername(String username) {
		this.username = username;
	}
	//get方法
	public String getPassword() {
		return password;
	}

	//set方法
	public void setPassword(String password) {
		this.password = password;
	}
	//get方法
	public String getPhone() {
		return phone;
	}

	//set方法
	public void setPhone(String phone) {
		this.phone = phone;
	}
	//get方法
	public String getEmail() {
		return email;
	}

	//set方法
	public void setEmail(String email) {
		this.email = email;
	}
	//get方法
	public Date getCreated() {
		return created;
	}

	//set方法
	public void setCreated(Date created) {
		this.created = created;
	}
	//get方法
	public Date getUpdated() {
		return updated;
	}

	//set方法
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	//get方法
	public String getSourceSourceType() {
		return sourceSourceType;
	}

	//set方法
	public void setSourceSourceType(String sourceSourceType) {
		this.sourceSourceType = sourceSourceType;
	}
	//get方法
	public String getNickNickName() {
		return nickNickName;
	}

	//set方法
	public void setNickNickName(String nickNickName) {
		this.nickNickName = nickNickName;
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
	public String getStatus() {
		return status;
	}

	//set方法
	public void setStatus(String status) {
		this.status = status;
	}
	//get方法
	public String getHeadHeadPic() {
		return headHeadPic;
	}

	//set方法
	public void setHeadHeadPic(String headHeadPic) {
		this.headHeadPic = headHeadPic;
	}
	//get方法
	public String getQq() {
		return qq;
	}

	//set方法
	public void setQq(String qq) {
		this.qq = qq;
	}
	//get方法
	public String getIsIsMobileCheck() {
		return isIsMobileCheck;
	}

	//set方法
	public void setIsIsMobileCheck(String isIsMobileCheck) {
		this.isIsMobileCheck = isIsMobileCheck;
	}
	//get方法
	public String getIsIsEmailCheck() {
		return isIsEmailCheck;
	}

	//set方法
	public void setIsIsEmailCheck(String isIsEmailCheck) {
		this.isIsEmailCheck = isIsEmailCheck;
	}
	//get方法
	public String getSex() {
		return sex;
	}

	//set方法
	public void setSex(String sex) {
		this.sex = sex;
	}
	//get方法
	public Integer getUserUserLevel() {
		return userUserLevel;
	}

	//set方法
	public void setUserUserLevel(Integer userUserLevel) {
		this.userUserLevel = userUserLevel;
	}
	//get方法
	public Integer getPoints() {
		return points;
	}

	//set方法
	public void setPoints(Integer points) {
		this.points = points;
	}
	//get方法
	public Integer getExperienceExperienceValue() {
		return experienceExperienceValue;
	}

	//set方法
	public void setExperienceExperienceValue(Integer experienceExperienceValue) {
		this.experienceExperienceValue = experienceExperienceValue;
	}
	//get方法
	public Date getBirthday() {
		return birthday;
	}

	//set方法
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	//get方法
	public Date getLastLastLoginTime() {
		return lastLastLoginTime;
	}

	//set方法
	public void setLastLastLoginTime(Date lastLastLoginTime) {
		this.lastLastLoginTime = lastLastLoginTime;
	}


}
