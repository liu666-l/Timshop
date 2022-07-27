package com.user.pojo;

import javax.persistence.*;
import java.io.Serializable;


@Table(name="tb_template")
public class Template implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//ID

    @Column(name = "name")
	private String name;//模板名称

    @Column(name = "spec_num")
	private Integer specSpecNum;//规格数量

    @Column(name = "para_num")
	private Integer paraParaNum;//参数数量



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getSpecSpecNum() {
		return specSpecNum;
	}

	//set方法
	public void setSpecSpecNum(Integer specSpecNum) {
		this.specSpecNum = specSpecNum;
	}
	//get方法
	public Integer getParaParaNum() {
		return paraParaNum;
	}

	//set方法
	public void setParaParaNum(Integer paraParaNum) {
		this.paraParaNum = paraParaNum;
	}


}
