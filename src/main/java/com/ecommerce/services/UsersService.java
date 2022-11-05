package com.ecommerce.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.Entities.Users;
import com.ecommerce.dto.UserGetRequestBody;
import com.ecommerce.dto.UserRegisterRequestBody;
import com.ecommerce.dto.UserUpdateRequestBody;
import com.ecommerce.repositories.UserRepo;

@Service
public class UsersService {

	Logger logger = LoggerFactory.getLogger(UsersService.class);

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	UserRepo userRepo;

	public Users saveUser(UserRegisterRequestBody user) {

		Users u = new Users();

		logger.info("After Calling Save Data method" + user);
		u.setPassword(passwordEncoder.encode(user.getPassword()));
		u.setUserName(user.getUserName());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setEmail(user.getEmail());
		u.setMobileNumber(user.getMobileNumber());
		u.setStatus(user.getStatus());
		u.setCity(user.getCity());
		u.setStreet(user.getStreet());
		u.setPincode(user.getPincode());
		u.setCreatedAt(new Date());
		u.setUpdatedAt(new Date());

		logger.info("before saving in data base" + u);

		u = userRepo.save(u);

		logger.info("after saving in data base" + u);
		return u;
	}

	public List<Users> getAllUser() {

		return userRepo.findAll();
	}

	public List<UserGetRequestBody> getUser() {
		List<UserGetRequestBody> res = new ArrayList<>();
		List<Users> us = userRepo.findAll();

		// traditional way

		for (Users u : us) {
			res.add(new UserGetRequestBody(u.getUserId(), u.getUserName(), u.getFirstName(), u.getLastName(),
					u.getEmail(), u.getStatus(), u.getCity(), u.getStreet(), u.getPincode(), u.getCreatedAt(),
					u.getUpdatedAt()));
		}

		for (UserGetRequestBody s : res) {
			System.out.println(s);
		}

		// By using Stream // anonymous implemented of functional interface

		us.stream().map(new Function<Users, UserGetRequestBody>() {

			@Override
			public UserGetRequestBody apply(Users t) {
				// TODO Auto-generated method stub
				return new UserGetRequestBody(t.getUserId(), t.getUserName(), t.getFirstName(), t.getLastName(),
						t.getEmail(), t.getStatus(), t.getCity(), t.getStreet(), t.getPincode(), t.getCreatedAt(),
						t.getUpdatedAt());
			}

		});

		// 2nd way using lambda expression

		List<UserGetRequestBody> userDto = us.stream()
				.map((Users t) -> new UserGetRequestBody(t.getUserId(), t.getUserName(), t.getFirstName(),
						t.getLastName(), t.getEmail(), t.getStatus(), t.getCity(), t.getStreet(), t.getPincode(),
						t.getCreatedAt(), t.getUpdatedAt()))
				.collect(Collectors.toList());

		return userDto;

	}

	public Users getOneUser(int userId) {
		Users res = userRepo.findById(userId).get();
		return res;
	}

	public Users updateUser(int userId, UserUpdateRequestBody user) {
		Users temp = userRepo.findById(userId).get();
		temp.setUserName(user.getUserName());
		temp.setPassword(passwordEncoder.encode(user.getPassword()));
		temp.setFirstName(user.getFirstName());
		temp.setLastName(user.getLastName());
		temp.setEmail(user.getEmail());
		temp.setMobileNumber(user.getMobileNumber());
		temp.setStatus(user.getStatus());
		temp.setCity(user.getCity());
		temp.setStreet(user.getStreet());
		temp.setPincode(user.getPincode());
		temp.setUpdatedAt(new Date());
		
		return userRepo.save(temp);
		
	}

	public void deleteUser(int userId) {
		Users temp = userRepo.findById(userId).get();
		
		userRepo.delete(temp);
		
	}

}
