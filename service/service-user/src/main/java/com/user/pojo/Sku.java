package com.user.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Table(name="tb_sku")
public class Sku implements Serializable{

	@Id
    @Column(name = "id")
	private Long id;//商品id

    @Column(name = "sn")
	private String sn;//商品条码

    @Column(name = "name")
	private String name;//SKU名称

    @Column(name = "price")
	private Integer price;//价格（分）

    @Column(name = "num")
	private Integer num;//库存数量

    @Column(name = "alert_num")
	private Integer alertAlertNum;//库存预警数量

    @Column(name = "image")
	private String image;//商品图片

    @Column(name = "images")
	private String images;//商品图片列表

    @Column(name = "weight")
	private Integer weight;//重量（克）

    @Column(name = "create_time")
	private Date createCreateTime;//创建时间

    @Column(name = "update_time")
	private Date updateUpdateTime;//更新时间

    @Column(name = "spu_id")
	private Long spuSpuId;//SPUID

    @Column(name = "category_id")
	private Integer categoryCategoryId;//类目ID

    @Column(name = "category_name")
	private String categoryCategoryName;//类目名称

    @Column(name = "brand_name")
	private String brandBrandName;//品牌名称

    @Column(name = "spec")
	private String spec;//规格

    @Column(name = "sale_num")
	private Integer saleSaleNum;//销量

    @Column(name = "comment_num")
	private Integer commentCommentNum;//评论数

    @Column(name = "status")
	private String status;//商品状态 1-正常，2-下架，3-删除



	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
	}
	//get方法
	public String getSn() {
		return sn;
	}

	//set方法
	public void setSn(String sn) {
		this.sn = sn;
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
	public Integer getPrice() {
		return price;
	}

	//set方法
	public void setPrice(Integer price) {
		this.price = price;
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
	public Integer getAlertAlertNum() {
		return alertAlertNum;
	}

	//set方法
	public void setAlertAlertNum(Integer alertAlertNum) {
		this.alertAlertNum = alertAlertNum;
	}
	//get方法
	public String getImage() {
		return image;
	}

	//set方法
	public void setImage(String image) {
		this.image = image;
	}
	//get方法
	public String getImages() {
		return images;
	}

	//set方法
	public void setImages(String images) {
		this.images = images;
	}
	//get方法
	public Integer getWeight() {
		return weight;
	}

	//set方法
	public void setWeight(Integer weight) {
		this.weight = weight;
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
	public Long getSpuSpuId() {
		return spuSpuId;
	}

	//set方法
	public void setSpuSpuId(Long spuSpuId) {
		this.spuSpuId = spuSpuId;
	}
	//get方法
	public Integer getCategoryCategoryId() {
		return categoryCategoryId;
	}

	//set方法
	public void setCategoryCategoryId(Integer categoryCategoryId) {
		this.categoryCategoryId = categoryCategoryId;
	}
	//get方法
	public String getCategoryCategoryName() {
		return categoryCategoryName;
	}

	//set方法
	public void setCategoryCategoryName(String categoryCategoryName) {
		this.categoryCategoryName = categoryCategoryName;
	}
	//get方法
	public String getBrandBrandName() {
		return brandBrandName;
	}

	//set方法
	public void setBrandBrandName(String brandBrandName) {
		this.brandBrandName = brandBrandName;
	}
	//get方法
	public String getSpec() {
		return spec;
	}

	//set方法
	public void setSpec(String spec) {
		this.spec = spec;
	}
	//get方法
	public Integer getSaleSaleNum() {
		return saleSaleNum;
	}

	//set方法
	public void setSaleSaleNum(Integer saleSaleNum) {
		this.saleSaleNum = saleSaleNum;
	}
	//get方法
	public Integer getCommentCommentNum() {
		return commentCommentNum;
	}

	//set方法
	public void setCommentCommentNum(Integer commentCommentNum) {
		this.commentCommentNum = commentCommentNum;
	}
	//get方法
	public String getStatus() {
		return status;
	}

	//set方法
	public void setStatus(String status) {
		this.status = status;
	}


}
