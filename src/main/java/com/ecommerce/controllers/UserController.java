package com.ecommerce.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Entities.Users;
import com.ecommerce.dto.UserGetRequestBody;
import com.ecommerce.dto.UserRegisterRequestBody;
import com.ecommerce.dto.UserUpdateRequestBody;
import com.ecommerce.services.UsersService;
import com.ecommerce.validation.UserRequestBodyValidation;

@RestController
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UsersService userService;

	@PostMapping("/signup")
	public ResponseEntity<?> userRegister(@RequestBody UserRegisterRequestBody user) {

		try {
			logger.info("Received user {}", user);
			UserRequestBodyValidation.validateUserName(user.getUserName());
			UserRequestBodyValidation.validateUserPassword(user.getPassword());
			UserRequestBodyValidation.validateEmail(user.getEmail());
			UserRequestBodyValidation.validateUserMobileNumber(user.getMobileNumber());

			Users userSaved = this.userService.saveUser(user);
			logger.info("user saved");
			return new ResponseEntity<>(userSaved, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);

		}

	}

	@GetMapping("/getallusers")
	public ResponseEntity<?> getAllUser() {
		List<Users> users;
		try {
			users = userService.getAllUser();
			if (users.isEmpty()) {
				return new ResponseEntity<>("Not found any users", HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getuser")
	public ResponseEntity<?> getUser() {
		List<UserGetRequestBody> res;
		try {
			res = userService.getUser();
			if (res.isEmpty()) {
				return new ResponseEntity<>("Not found any users", HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<?> getOneUser(@PathVariable int userId) {
		Users temp = null;
		try {
			UserRequestBodyValidation.validateUserId(userId);
			temp = userService.getOneUser(userId);
			logger.info("user details found");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);

		} catch (Exception e) {

			logger.error("Exception occured, {}", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
		}

	}

	@PutMapping("/updateuser/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable int userId, @RequestBody UserUpdateRequestBody user) {
		Users temp = null;
		try {
			UserRequestBodyValidation.validateUserId(userId);
			UserRequestBodyValidation.validateUserName(user.getUserName());
			UserRequestBodyValidation.validateUserPassword(user.getPassword());
			UserRequestBodyValidation.validateEmail(user.getEmail());
			UserRequestBodyValidation.validateUserMobileNumber(user.getMobileNumber());
			UserRequestBodyValidation.validateStatus(user.getStatus());

			temp = this.userService.updateUser(userId, user);
			logger.info("user updated successfully");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
		}

	}

	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable int userId) {
		try {
			UserRequestBodyValidation.validateUserId(userId);
			userService.deleteUser(userId);
			logger.info("user successfully deleted");
			return new ResponseEntity<String>("user has been deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<String>("user has not been deleted", HttpStatus.NOT_FOUND);

		}

	}

}
