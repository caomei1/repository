package ssm.entity;

public class Order {
	private Integer id;
	private Integer userId; //用户id 
	private Integer addressId; //收货地址id
	private String price; //价格
	private String paymentMode; //支付方式
	private String creationTime; //订单创建时间
	private String state; //状态
	
	private ReceivingAddress receivingAddress;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "VipOrderList [id=" + id + ", userId=" + userId + ", addressId=" + addressId + ", price=" + price
				+ ", paymentMode=" + paymentMode + ", creationTime=" + creationTime + ", state=" + state + "]";
	}
	public ReceivingAddress getReceivingAddress() {
		return receivingAddress;
	}
	public void setReceivingAddress(ReceivingAddress receivingAddress) {
		this.receivingAddress = receivingAddress;
	}
	

}
