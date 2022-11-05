package com.ecommerce.dto;

import java.util.Date;

public class UserUpdateRequestBody {
	
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private String status;
	private String city;
	private String street;
	private String pincode;
	private Date updatedAt;
	public UserUpdateRequestBody() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserUpdateRequestBody(String userName, String password, String firstName, String lastName, String email,
			String mobileNumber, String status, String city, String street, String pincode, Date updatedAt) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.status = status;
		this.city = city;
		this.street = street;
		this.pincode = pincode;
		this.updatedAt = updatedAt;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "UserUpdateResponseBody [userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", mobileNumber=" + mobileNumber + ", status="
				+ status + ", city=" + city + ", street=" + street + ", pincode=" + pincode + ", updatedAt=" + updatedAt
				+ "]";
	}
	
	
	

}
