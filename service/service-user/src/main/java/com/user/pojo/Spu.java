package com.user.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Table(name="tb_spu")
public class Spu implements Serializable{

	@Id
    @Column(name = "id")
	private Long id;//主键

    @Column(name = "sn")
	private String sn;//货号

    @Column(name = "name")
	private String name;//SPU名

    @Column(name = "caption")
	private String caption;//副标题

    @Column(name = "brand_id")
	private Integer brandBrandId;//品牌ID

    @Column(name = "category1_id")
	private Integer category1Category1Id;//一级分类

    @Column(name = "category2_id")
	private Integer category2Category2Id;//二级分类

    @Column(name = "category3_id")
	private Integer category3Category3Id;//三级分类

    @Column(name = "template_id")
	private Integer templateTemplateId;//模板ID

    @Column(name = "freight_id")
	private Integer freightFreightId;//运费模板id

    @Column(name = "image")
	private String image;//图片

    @Column(name = "images")
	private String images;//图片列表

    @Column(name = "sale_service")
	private String saleSaleService;//售后服务

    @Column(name = "introduction")
	private String introduction;//介绍

    @Column(name = "spec_items")
	private String specSpecItems;//规格列表

    @Column(name = "para_items")
	private String paraParaItems;//参数列表

    @Column(name = "sale_num")
	private Integer saleSaleNum;//销量

    @Column(name = "comment_num")
	private Integer commentCommentNum;//评论数

    @Column(name = "is_marketable")
	private String isIsMarketable;//是否上架

    @Column(name = "is_enable_spec")
	private String isIsEnableSpec;//是否启用规格

    @Column(name = "is_delete")
	private String isIsDelete;//是否删除

    @Column(name = "status")
	private String status;//审核状态



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
	public String getCaption() {
		return caption;
	}

	//set方法
	public void setCaption(String caption) {
		this.caption = caption;
	}
	//get方法
	public Integer getBrandBrandId() {
		return brandBrandId;
	}

	//set方法
	public void setBrandBrandId(Integer brandBrandId) {
		this.brandBrandId = brandBrandId;
	}
	//get方法
	public Integer getCategory1Category1Id() {
		return category1Category1Id;
	}

	//set方法
	public void setCategory1Category1Id(Integer category1Category1Id) {
		this.category1Category1Id = category1Category1Id;
	}
	//get方法
	public Integer getCategory2Category2Id() {
		return category2Category2Id;
	}

	//set方法
	public void setCategory2Category2Id(Integer category2Category2Id) {
		this.category2Category2Id = category2Category2Id;
	}
	//get方法
	public Integer getCategory3Category3Id() {
		return category3Category3Id;
	}

	//set方法
	public void setCategory3Category3Id(Integer category3Category3Id) {
		this.category3Category3Id = category3Category3Id;
	}
	//get方法
	public Integer getTemplateTemplateId() {
		return templateTemplateId;
	}

	//set方法
	public void setTemplateTemplateId(Integer templateTemplateId) {
		this.templateTemplateId = templateTemplateId;
	}
	//get方法
	public Integer getFreightFreightId() {
		return freightFreightId;
	}

	//set方法
	public void setFreightFreightId(Integer freightFreightId) {
		this.freightFreightId = freightFreightId;
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
	public String getSaleSaleService() {
		return saleSaleService;
	}

	//set方法
	public void setSaleSaleService(String saleSaleService) {
		this.saleSaleService = saleSaleService;
	}
	//get方法
	public String getIntroduction() {
		return introduction;
	}

	//set方法
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	//get方法
	public String getSpecSpecItems() {
		return specSpecItems;
	}

	//set方法
	public void setSpecSpecItems(String specSpecItems) {
		this.specSpecItems = specSpecItems;
	}
	//get方法
	public String getParaParaItems() {
		return paraParaItems;
	}

	//set方法
	public void setParaParaItems(String paraParaItems) {
		this.paraParaItems = paraParaItems;
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
	public String getIsIsMarketable() {
		return isIsMarketable;
	}

	//set方法
	public void setIsIsMarketable(String isIsMarketable) {
		this.isIsMarketable = isIsMarketable;
	}
	//get方法
	public String getIsIsEnableSpec() {
		return isIsEnableSpec;
	}

	//set方法
	public void setIsIsEnableSpec(String isIsEnableSpec) {
		this.isIsEnableSpec = isIsEnableSpec;
	}
	//get方法
	public String getIsIsDelete() {
		return isIsDelete;
	}

	//set方法
	public void setIsIsDelete(String isIsDelete) {
		this.isIsDelete = isIsDelete;
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
