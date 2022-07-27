package com.user.pojo;

import javax.persistence.*;
import java.io.Serializable;


@Table(name="tb_category")
public class Category implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//分类ID

    @Column(name = "name")
	private String name;//分类名称

    @Column(name = "goods_num")
	private Integer goodsGoodsNum;//商品数量

    @Column(name = "is_show")
	private String isIsShow;//是否显示

    @Column(name = "is_menu")
	private String isIsMenu;//是否导航

    @Column(name = "seq")
	private Integer seq;//排序

    @Column(name = "parent_id")
	private Integer parentParentId;//上级ID

    @Column(name = "template_id")
	private Integer templateTemplateId;//模板ID



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
	public Integer getGoodsGoodsNum() {
		return goodsGoodsNum;
	}

	//set方法
	public void setGoodsGoodsNum(Integer goodsGoodsNum) {
		this.goodsGoodsNum = goodsGoodsNum;
	}
	//get方法
	public String getIsIsShow() {
		return isIsShow;
	}

	//set方法
	public void setIsIsShow(String isIsShow) {
		this.isIsShow = isIsShow;
	}
	//get方法
	public String getIsIsMenu() {
		return isIsMenu;
	}

	//set方法
	public void setIsIsMenu(String isIsMenu) {
		this.isIsMenu = isIsMenu;
	}
	//get方法
	public Integer getSeq() {
		return seq;
	}

	//set方法
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	//get方法
	public Integer getParentParentId() {
		return parentParentId;
	}

	//set方法
	public void setParentParentId(Integer parentParentId) {
		this.parentParentId = parentParentId;
	}
	//get方法
	public Integer getTemplateTemplateId() {
		return templateTemplateId;
	}

	//set方法
	public void setTemplateTemplateId(Integer templateTemplateId) {
		this.templateTemplateId = templateTemplateId;
	}


}
