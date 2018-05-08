package ssm.entity;

import java.util.List;

public class User {
	private String username;
	private String password;
	private int phone_number;
	private String email;
	private String role;
	
	private List<String> permissions;
	
	public List<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
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
	public int getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(int phone_number) {
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
		return "User [username=" + username + ", password=" + password + ", phone_number=" + phone_number + ", email="
				+ email + ", role=" + role +"]";
	}
	
}
