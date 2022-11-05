package com.ecommerce.validation;

public class UserRequestBodyValidation {
	public static void validateUserMobileNumber(String mobileNumber) throws Exception {

		if (mobileNumber.length() != 10)
			throw new Exception("invalid mobileNUmber");
	}

	public static void validateUserName(String userName) throws Exception {
		if (userName.length() == 0)
			throw new Exception("UserName not found");
	}

	public static void validateUserPassword(String password) throws Exception {
		if (password.length() == 0)
			throw new Exception("invalid passsword");
	}
	
	public static void validateFirstName(String firstName) throws Exception{
		if(firstName.length() == 0)
			throw new Exception("first name not found");
		
	}
	
	public static void validateLastName(String lastName) throws Exception {
		if (lastName.length() == 0)
			throw new Exception("Last name not found");
	}
	
	public static void validateEmail(String email) throws Exception {
		if (email.length() == 0)
			throw new Exception("email not found");
	}
	
	public static void validateStatus(String status) throws Exception {
		if (status.length() == 0)
			throw new Exception("status not found");
	}
	
	public static void validateCity(String city) throws Exception {
		if (city.length() == 0)
			throw new Exception("city not found");
	}
	
	public static void validateStreet(String street) throws Exception {
		if (street.length() == 0)
			throw new Exception("street not found");
	}
	
	public static void validatePincode(String pincode) throws Exception {
		if (pincode.length() == 0)
			throw new Exception("pincode not found");
	}
	
	public static void validateUserId(int userId) throws Exception {
		String id;
		id = String.valueOf(userId);
		if (id.length() == 0)
			throw new Exception("invalid user Id");
	}
	

	

}
