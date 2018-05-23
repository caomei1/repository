package ssm.entity;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	private Integer id;
	
	@Size(min = 2, max = 15, message = "2 ~ 15个字")
	private String username;
	
	@Size(min = 6, max = 64, message = "6 ~ 64位")
	private String password;
	
	@Pattern(regexp="^1[3|4|5|7|8][0-9]{9}$",message="请输入正确的手机号")
	private String phone_number;
	
	@Email(regexp="^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$",message="请输入正确的邮箱")
	private String email;
	
	private String role;
	
	private String realName;
	private String city;
	private String sex;
	private String idCard;
	private String introduce;
	private String picture;
	
	private List<String> permissions;
	
	private List<ReceivingAddress> receivingAddress;//收货地址
	
	private List<Order> vipOrderList;//vip我的订单
	
	private Car car;
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	public List<Order> getVipOrderList() {
		return vipOrderList;
	}
	public void setVipOrderList(List<Order> vipOrderList) {
		this.vipOrderList = vipOrderList;
	}
	
	public List<ReceivingAddress> getReceivingAddress() {
		return receivingAddress;
	}
	public void setReceivingAddress(List<ReceivingAddress> receivingAddress) {
		this.receivingAddress = receivingAddress;
	}
	
	public List<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRealName() {
		return realName;
	}
	public void setRealName(String real_name) {
		this.realName = real_name;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String id_card) {
		this.idCard = id_card;
	}
	
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", phone_number=" + phone_number
				+ ", email=" + email + ", role=" + role + ", realName=" + realName + ", city=" + city + ", sex=" + sex
				+ ", idCard=" + idCard + ", introduce=" + introduce + ", picture=" + picture + ", permissions="
				+ permissions + ", receivingAddress=" + receivingAddress + ", vipOrderList=" + vipOrderList + ", car="
				+ car + "]";
	}
	
}
