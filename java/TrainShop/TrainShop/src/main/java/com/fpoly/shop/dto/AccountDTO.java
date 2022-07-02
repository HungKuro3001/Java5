package com.fpoly.shop.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {
	
	private String id;
	
	@NotEmpty(message="Phải nhập địa chỉ email")
	@Email(message= "Phải nhập đúng địa chỉ email")
	private String email;

	@Length(min=8, max=32, message="mật khẩu phải dài 8-32 ký tự")
	private String password;
	
	private String confirmPassword;
	
	@NotEmpty(message="Địa chỉ không được trống")
	private String address;
	
	@NotEmpty(message="Họ tên không được trống")
	private String name;
	
	@NotEmpty(message="Số điện thoại không được trống")
	private String sdt;
	private String roleName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	

}
