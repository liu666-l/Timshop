package com.order.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Table(name="tb_category_report")
public class CategoryCategoryReport implements Serializable{

    @Column(name = "category_id1")
	private Integer categoryCategoryId1;//1级分类

    @Column(name = "category_id2")
	private Integer categoryCategoryId2;//2级分类

    @Column(name = "category_id3")
	private Integer categoryCategoryId3;//3级分类

	@Id
    @Column(name = "count_date")
	private Date countCountDate;//统计日期

    @Column(name = "num")
	private Integer num;//销售数量

    @Column(name = "money")
	private Integer money;//销售额



	//get方法
	public Integer getCategoryCategoryId1() {
		return categoryCategoryId1;
	}

	//set方法
	public void setCategoryCategoryId1(Integer categoryCategoryId1) {
		this.categoryCategoryId1 = categoryCategoryId1;
	}
	//get方法
	public Integer getCategoryCategoryId2() {
		return categoryCategoryId2;
	}

	//set方法
	public void setCategoryCategoryId2(Integer categoryCategoryId2) {
		this.categoryCategoryId2 = categoryCategoryId2;
	}
	//get方法
	public Integer getCategoryCategoryId3() {
		return categoryCategoryId3;
	}

	//set方法
	public void setCategoryCategoryId3(Integer categoryCategoryId3) {
		this.categoryCategoryId3 = categoryCategoryId3;
	}
	//get方法
	public Date getCountCountDate() {
		return countCountDate;
	}

	//set方法
	public void setCountCountDate(Date countCountDate) {
		this.countCountDate = countCountDate;
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


}
