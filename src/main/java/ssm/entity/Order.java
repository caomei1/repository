package ssm.entity;

public class Order {
	private Integer id;
	private Integer userId; //用户id 
	private Integer addressId; //收货地址id
	private Integer productId; //商品id
	private String payment; //支付方式
	private String creationTime; //订单创建时间
	private String state; //状态
	
	private Product product; //商品
	
	private User user;
	
	private ReceivingAddress receivingAddress; //收货地址

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ReceivingAddress getReceivingAddress() {
		return receivingAddress;
	}

	public void setReceivingAddress(ReceivingAddress receivingAddress) {
		this.receivingAddress = receivingAddress;
	}
	
}
