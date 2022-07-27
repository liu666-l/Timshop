package pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="tb_seckill_goods")
public class SeckillSeckillGoods implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//

    @Column(name = "goods_id")
	private Long goodsGoodsId;//spu ID

    @Column(name = "item_id")
	private Long itemItemId;//sku ID

    @Column(name = "title")
	private String title;//标题

    @Column(name = "small_pic")
	private String smallSmallPic;//商品图片

    @Column(name = "price")
	private String price;//原价格

    @Column(name = "cost_price")
	private String costCostPrice;//秒杀价格

    @Column(name = "seller_id")
	private String sellerSellerId;//商家ID

    @Column(name = "create_time")
	private Date createCreateTime;//添加日期

    @Column(name = "check_time")
	private Date checkCheckTime;//审核日期

    @Column(name = "status")
	private String status;//审核状态，0未审核，1审核通过，2审核不通过

    @Column(name = "start_time")
	private Date startStartTime;//开始时间

    @Column(name = "end_time")
	private Date endEndTime;//结束时间

    @Column(name = "num")
	private Integer num;//秒杀商品数

    @Column(name = "stock_count")
	private Integer stockStockCount;//剩余库存数

    @Column(name = "introduction")
	private String introduction;//描述



	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
	}
	//get方法
	public Long getGoodsGoodsId() {
		return goodsGoodsId;
	}

	//set方法
	public void setGoodsGoodsId(Long goodsGoodsId) {
		this.goodsGoodsId = goodsGoodsId;
	}
	//get方法
	public Long getItemItemId() {
		return itemItemId;
	}

	//set方法
	public void setItemItemId(Long itemItemId) {
		this.itemItemId = itemItemId;
	}
	//get方法
	public String getTitle() {
		return title;
	}

	//set方法
	public void setTitle(String title) {
		this.title = title;
	}
	//get方法
	public String getSmallSmallPic() {
		return smallSmallPic;
	}

	//set方法
	public void setSmallSmallPic(String smallSmallPic) {
		this.smallSmallPic = smallSmallPic;
	}
	//get方法
	public String getPrice() {
		return price;
	}

	//set方法
	public void setPrice(String price) {
		this.price = price;
	}
	//get方法
	public String getCostCostPrice() {
		return costCostPrice;
	}

	//set方法
	public void setCostCostPrice(String costCostPrice) {
		this.costCostPrice = costCostPrice;
	}
	//get方法
	public String getSellerSellerId() {
		return sellerSellerId;
	}

	//set方法
	public void setSellerSellerId(String sellerSellerId) {
		this.sellerSellerId = sellerSellerId;
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
	public Date getCheckCheckTime() {
		return checkCheckTime;
	}

	//set方法
	public void setCheckCheckTime(Date checkCheckTime) {
		this.checkCheckTime = checkCheckTime;
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
	public Date getStartStartTime() {
		return startStartTime;
	}

	//set方法
	public void setStartStartTime(Date startStartTime) {
		this.startStartTime = startStartTime;
	}
	//get方法
	public Date getEndEndTime() {
		return endEndTime;
	}

	//set方法
	public void setEndEndTime(Date endEndTime) {
		this.endEndTime = endEndTime;
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
	public Integer getStockStockCount() {
		return stockStockCount;
	}

	//set方法
	public void setStockStockCount(Integer stockStockCount) {
		this.stockStockCount = stockStockCount;
	}
	//get方法
	public String getIntroduction() {
		return introduction;
	}

	//set方法
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}


}
