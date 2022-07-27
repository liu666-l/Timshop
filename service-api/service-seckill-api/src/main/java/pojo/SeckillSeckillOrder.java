package pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name="tb_seckill_order")
public class SeckillSeckillOrder implements Serializable{

	@Id
    @Column(name = "id")
	private Long id;//主键

    @Column(name = "seckill_id")
	private Long seckillSeckillId;//秒杀商品ID

    @Column(name = "money")
	private String money;//支付金额

    @Column(name = "user_id")
	private String userUserId;//用户

    @Column(name = "seller_id")
	private String sellerSellerId;//商家

    @Column(name = "create_time")
	private Date createCreateTime;//创建时间

    @Column(name = "pay_time")
	private Date payPayTime;//支付时间

    @Column(name = "status")
	private String status;//状态，0未支付，1已支付

    @Column(name = "receiver_address")
	private String receiverReceiverAddress;//收货人地址

    @Column(name = "receiver_mobile")
	private String receiverReceiverMobile;//收货人电话

    @Column(name = "receiver")
	private String receiver;//收货人

    @Column(name = "transaction_id")
	private String transactionTransactionId;//交易流水



	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
	}
	//get方法
	public Long getSeckillSeckillId() {
		return seckillSeckillId;
	}

	//set方法
	public void setSeckillSeckillId(Long seckillSeckillId) {
		this.seckillSeckillId = seckillSeckillId;
	}
	//get方法
	public String getMoney() {
		return money;
	}

	//set方法
	public void setMoney(String money) {
		this.money = money;
	}
	//get方法
	public String getUserUserId() {
		return userUserId;
	}

	//set方法
	public void setUserUserId(String userUserId) {
		this.userUserId = userUserId;
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
	public Date getPayPayTime() {
		return payPayTime;
	}

	//set方法
	public void setPayPayTime(Date payPayTime) {
		this.payPayTime = payPayTime;
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
	public String getReceiverReceiverAddress() {
		return receiverReceiverAddress;
	}

	//set方法
	public void setReceiverReceiverAddress(String receiverReceiverAddress) {
		this.receiverReceiverAddress = receiverReceiverAddress;
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
	public String getReceiver() {
		return receiver;
	}

	//set方法
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	//get方法
	public String getTransactionTransactionId() {
		return transactionTransactionId;
	}

	//set方法
	public void setTransactionTransactionId(String transactionTransactionId) {
		this.transactionTransactionId = transactionTransactionId;
	}


}
