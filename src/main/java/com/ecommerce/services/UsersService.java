package com.ecommerce.services;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.Entities.Address;
import com.ecommerce.Entities.Users;
import com.ecommerce.dto.UserRegisterRequestBody;
import com.ecommerce.dto.UserUpdateRequestBody;
import com.ecommerce.repositories.AddressRepo;
import com.ecommerce.repositories.UserRepo;

@Service
@Transactional
public class UsersService {

	Logger logger = LoggerFactory.getLogger(UsersService.class);

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	UserRepo userRepo;

	@Autowired
	AddressRepo addressRepo;

	public Users saveUser(UserRegisterRequestBody user) {

		Users u = new Users();
		logger.info("After Calling Save Data method" + user);
		u.setPassword(passwordEncoder.encode(user.getPassword()));
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setEmail(user.getEmail());
		u.setMobileNumber(user.getMobileNumber());
		u.setCreatedAt(new Date());
		u.setUpdatedAt(new Date());
		//u.setAdresses(user.getAdresses());
		Users us = userRepo.save(u);

		List<Address> addressRequest = user.getAdresses();
		for (Address x : addressRequest) {
			Address ad = new Address();
			ad.setCity(x.getCity());
			ad.setHouseNumber(x.getHouseNumber());
			ad.setStreet(x.getStreet());
			ad.setPincode(x.getPincode());
			ad.setCreatedAt(new Date());
			ad.setUpdatedAt(new Date());
			ad.setUser(us);
			System.out.println( "saved user in address "+us);
			Address a = addressRepo.save(ad);
			u.getAdresses().add(a);
			System.out.println( "saved user in address "+us);
		}
		return us;
	}

	public List<Users> getAllUser() {

		return userRepo.findAll();
	}

	public Users getOneUser(int userId) {
		return userRepo.findById(userId)
				.orElseThrow(() -> new NoSuchElementException("NO CUSTOMER PRESENT WITH ID = " + userId));
	}

	public Users updateUser(int userId, UserUpdateRequestBody user) {
		Users temp = userRepo.findById(userId).get();
		temp.setPassword(passwordEncoder.encode(user.getPassword()));
		temp.setFirstName(user.getFirstName());
		temp.setLastName(user.getLastName());
		temp.setUpdatedAt(new Date());

		return userRepo.save(temp);

	}

	public void deleteUser(int userId) {
		Users temp = userRepo.findById(userId).get();
		userRepo.delete(temp);
	}

	public Users findByEmail(String email) {
		Users temp = userRepo.findByEmail(email);
		return temp;
	}

	public Users getUserById(int userId) {
		return userRepo.findById(userId).get();
	}

}
