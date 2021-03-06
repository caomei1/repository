package ssm.entity;

import java.util.List;

public class ReceivingAddress {
	private Integer id;
	private Integer userId; //用户id
	private String consignee; //收货人
	private String whereCity; //所在城市
	private String streetAddress; //详细街道
	private String postalCode; //邮政编码
	private String phoneNumber; //手机号
	
	private List<Order> vipOrderList; //vip我的订单
	
	public List<Order> getVipOrderList() {
		return vipOrderList;
	}
	public void setVipOrderList(List<Order> vipOrderList) {
		this.vipOrderList = vipOrderList;
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
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getWhereCity() {
		return whereCity;
	}
	public void setWhereCity(String whereCity) {
		this.whereCity = whereCity;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "ReceivingAddress [id=" + id + ", userId=" + userId + ", consignee=" + consignee + ", whereCity="
				+ whereCity + ", streetAddress=" + streetAddress + ", postalCode=" + postalCode + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
}
