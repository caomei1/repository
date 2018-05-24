package ssm.entity;

public class Product {
	private Integer id;
	private String brand; //品牌
	private String model; //型号
	private String title; //标题
	private String price; //价格
	private String orderNumber; //商品编号
	private String freight; //运费
	private String bodyColor; //机身颜色
	private String memory; //内存
	private String stock; //库存
	private String smartMachine; //智能机(是/否)
	private String networkMode; //网络制式
	private String business; //商家
	
	private Car car;
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getFreight() {
		return freight;
	}
	public void setFreight(String freight) {
		this.freight = freight;
	}
	public String getBodyColor() {
		return bodyColor;
	}
	public void setBodyColor(String bodyColor) {
		this.bodyColor = bodyColor;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getSmartMachine() {
		return smartMachine;
	}
	public void setSmartMachine(String smartMachine) {
		this.smartMachine = smartMachine;
	}
	public String getNetworkMode() {
		return networkMode;
	}
	public void setNetworkMode(String networkMode) {
		this.networkMode = networkMode;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", brand=" + brand + ", model=" + model + ", title=" + title + ", price=" + price
				+ ", orderNumber=" + orderNumber + ", freight=" + freight + ", bodyColor=" + bodyColor + ", memory="
				+ memory + ", stock=" + stock + ", smartMachine=" + smartMachine + ", networkMode=" + networkMode
				+ ", business=" + business + "]";
	}

}
