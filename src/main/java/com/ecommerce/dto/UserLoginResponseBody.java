package com.ecommerce.dto;

public class UserLoginResponseBody {
    
	private String userName;
	private String password;
	private String email;
	private String mobileNumber;
	
	
	public UserLoginResponseBody() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserLoginResponseBody(String userName, String password, String email, String mobileNumber) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
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


	@Override
	public String toString() {
		return "UserLoginResponseBody [userName=" + userName + ", password=" + password + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + "]";
	}
	
	

}
