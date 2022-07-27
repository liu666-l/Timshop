package com.user.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name="tb_category_brand")
public class CategoryCategoryBrand implements Serializable{

    @Column(name = "category_id")
	private Integer categoryCategoryId;//分类ID

	@Id
    @Column(name = "brand_id")
	private Integer brandBrandId;//品牌ID



	//get方法
	public Integer getCategoryCategoryId() {
		return categoryCategoryId;
	}

	//set方法
	public void setCategoryCategoryId(Integer categoryCategoryId) {
		this.categoryCategoryId = categoryCategoryId;
	}
	//get方法
	public Integer getBrandBrandId() {
		return brandBrandId;
	}

	//set方法
	public void setBrandBrandId(Integer brandBrandId) {
		this.brandBrandId = brandBrandId;
	}


}
