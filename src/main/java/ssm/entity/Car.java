package ssm.entity;

public class Car {
	private Integer id;
	private Integer userId; //用户id
	private Integer productId; //商品id
	private String quantity; //数量
	
	private Product product; //商品
	
	private User user;
	
	private ReceivingAddress receivingAddress; //收货地址
	
	public ReceivingAddress getReceivingAddress() {
		return receivingAddress;
	}
	public void setReceivingAddress(ReceivingAddress receivingAddress) {
		this.receivingAddress = receivingAddress;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
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
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", userId=" + userId + ", productId=" + productId + ", quantity=" + quantity + "]";
	}

}
