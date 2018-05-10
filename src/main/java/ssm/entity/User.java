package ssm.entity;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	private long id;
	
	@Size(min = 2, max = 15, message = "2 ~ 15个字")
	private String username;
	
	@Size(min = 6, max = 64, message = "6 ~ 64位")
	private String password;
	
	@Pattern(regexp="^1[3|4|5|7|8][0-9]{9}$",message="请输入正确的手机号")
	private String phone_number;
	
	@Email(regexp="^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$",message="请输入正确的邮箱")
	private String email;
	
	private String role;
	
	private List<String> permissions;
	
	public List<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", phone_number=" + phone_number
				+ ", email=" + email + ", role=" + role + "]";
	}
	
}
