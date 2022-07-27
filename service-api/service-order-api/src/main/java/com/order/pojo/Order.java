package com.order.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name="tb_order")
public class Order implements Serializable{

	@Id
    @Column(name = "id")
	private String id;//订单id

    @Column(name = "total_num")
	private Integer totalTotalNum;//数量合计

    @Column(name = "total_money")
	private Integer totalTotalMoney;//金额合计

    @Column(name = "pre_money")
	private Integer prePreMoney;//优惠金额

    @Column(name = "post_fee")
	private Integer postPostFee;//邮费

    @Column(name = "pay_money")
	private Integer payPayMoney;//实付金额

    @Column(name = "pay_type")
	private String payPayType;//支付类型，1、在线支付、0 货到付款

    @Column(name = "create_time")
	private Date createCreateTime;//订单创建时间

    @Column(name = "update_time")
	private Date updateUpdateTime;//订单更新时间

    @Column(name = "pay_time")
	private Date payPayTime;//付款时间

    @Column(name = "consign_time")
	private Date consignConsignTime;//发货时间

    @Column(name = "end_time")
	private Date endEndTime;//交易完成时间

    @Column(name = "close_time")
	private Date closeCloseTime;//交易关闭时间

    @Column(name = "shipping_name")
	private String shippingShippingName;//物流名称

    @Column(name = "shipping_code")
	private String shippingShippingCode;//物流单号

    @Column(name = "username")
	private String username;//用户名称

    @Column(name = "buyer_message")
	private String buyerBuyerMessage;//买家留言

    @Column(name = "buyer_rate")
	private String buyerBuyerRate;//是否评价

    @Column(name = "receiver_contact")
	private String receiverReceiverContact;//收货人

    @Column(name = "receiver_mobile")
	private String receiverReceiverMobile;//收货人手机

    @Column(name = "receiver_address")
	private String receiverReceiverAddress;//收货人地址

    @Column(name = "source_type")
	private String sourceSourceType;//订单来源：1:web，2：app，3：微信公众号，4：微信小程序  5 H5手机页面

    @Column(name = "transaction_id")
	private String transactionTransactionId;//交易流水号

    @Column(name = "order_status")
	private String orderOrderStatus;//订单状态 

    @Column(name = "pay_status")
	private String payPayStatus;//支付状态 0:未支付 1:已支付

    @Column(name = "consign_status")
	private String consignConsignStatus;//发货状态 0:未发货 1:已发货 2:已送达

    @Column(name = "is_delete")
	private String isIsDelete;//是否删除
	private List<Long> skuIds;

	public List<Long> getSkuIds() {
		return skuIds;
	}

	public void setSkuIds(List<Long> skuIds) {
		this.skuIds = skuIds;
	}

	//get方法
	public String getId() {
		return id;
	}

	//set方法
	public void setId(String id) {
		this.id = id;
	}
	//get方法
	public Integer getTotalTotalNum() {
		return totalTotalNum;
	}

	//set方法
	public void setTotalTotalNum(Integer totalTotalNum) {
		this.totalTotalNum = totalTotalNum;
	}
	//get方法
	public Integer getTotalTotalMoney() {
		return totalTotalMoney;
	}

	//set方法
	public void setTotalTotalMoney(Integer totalTotalMoney) {
		this.totalTotalMoney = totalTotalMoney;
	}
	//get方法
	public Integer getPrePreMoney() {
		return prePreMoney;
	}

	//set方法
	public void setPrePreMoney(Integer prePreMoney) {
		this.prePreMoney = prePreMoney;
	}
	//get方法
	public Integer getPostPostFee() {
		return postPostFee;
	}

	//set方法
	public void setPostPostFee(Integer postPostFee) {
		this.postPostFee = postPostFee;
	}
	//get方法
	public Integer getPayPayMoney() {
		return payPayMoney;
	}

	//set方法
	public void setPayPayMoney(Integer payPayMoney) {
		this.payPayMoney = payPayMoney;
	}
	//get方法
	public String getPayPayType() {
		return payPayType;
	}

	//set方法
	public void setPayPayType(String payPayType) {
		this.payPayType = payPayType;
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
	public Date getPayPayTime() {
		return payPayTime;
	}

	//set方法
	public void setPayPayTime(Date payPayTime) {
		this.payPayTime = payPayTime;
	}
	//get方法
	public Date getConsignConsignTime() {
		return consignConsignTime;
	}

	//set方法
	public void setConsignConsignTime(Date consignConsignTime) {
		this.consignConsignTime = consignConsignTime;
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
	public Date getCloseCloseTime() {
		return closeCloseTime;
	}

	//set方法
	public void setCloseCloseTime(Date closeCloseTime) {
		this.closeCloseTime = closeCloseTime;
	}
	//get方法
	public String getShippingShippingName() {
		return shippingShippingName;
	}

	//set方法
	public void setShippingShippingName(String shippingShippingName) {
		this.shippingShippingName = shippingShippingName;
	}
	//get方法
	public String getShippingShippingCode() {
		return shippingShippingCode;
	}

	//set方法
	public void setShippingShippingCode(String shippingShippingCode) {
		this.shippingShippingCode = shippingShippingCode;
	}
	//get方法
	public String getUsername() {
		return username;
	}

	//set方法
	public void setUsername(String username) {
		this.username = username;
	}
	//get方法
	public String getBuyerBuyerMessage() {
		return buyerBuyerMessage;
	}

	//set方法
	public void setBuyerBuyerMessage(String buyerBuyerMessage) {
		this.buyerBuyerMessage = buyerBuyerMessage;
	}
	//get方法
	public String getBuyerBuyerRate() {
		return buyerBuyerRate;
	}

	//set方法
	public void setBuyerBuyerRate(String buyerBuyerRate) {
		this.buyerBuyerRate = buyerBuyerRate;
	}
	//get方法
	public String getReceiverReceiverContact() {
		return receiverReceiverContact;
	}

	//set方法
	public void setReceiverReceiverContact(String receiverReceiverContact) {
		this.receiverReceiverContact = receiverReceiverContact;
	}
	//get方法
	public String getReceiverReceiverMobile() {
		return receiverReceiverMobile;
	}

	//set方法
	public void setReceiverReceiverMobile(String receiverReceiverMobile) {
		this.receiverReceiverMobile = receiverReceiverMobile;
	}
	//get方法
	public String getReceiverReceiverAddress() {
		return receiverReceiverAddress;
	}

	//set方法
	public void setReceiverReceiverAddress(String receiverReceiverAddress) {
		this.receiverReceiverAddress = receiverReceiverAddress;
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
	public String getTransactionTransactionId() {
		return transactionTransactionId;
	}

	//set方法
	public void setTransactionTransactionId(String transactionTransactionId) {
		this.transactionTransactionId = transactionTransactionId;
	}
	//get方法
	public String getOrderOrderStatus() {
		return orderOrderStatus;
	}

	//set方法
	public void setOrderOrderStatus(String orderOrderStatus) {
		this.orderOrderStatus = orderOrderStatus;
	}
	//get方法
	public String getPayPayStatus() {
		return payPayStatus;
	}

	//set方法
	public void setPayPayStatus(String payPayStatus) {
		this.payPayStatus = payPayStatus;
	}
	//get方法
	public String getConsignConsignStatus() {
		return consignConsignStatus;
	}

	//set方法
	public void setConsignConsignStatus(String consignConsignStatus) {
		this.consignConsignStatus = consignConsignStatus;
	}
	//get方法
	public String getIsIsDelete() {
		return isIsDelete;
	}

	//set方法
	public void setIsIsDelete(String isIsDelete) {
		this.isIsDelete = isIsDelete;
	}



}
