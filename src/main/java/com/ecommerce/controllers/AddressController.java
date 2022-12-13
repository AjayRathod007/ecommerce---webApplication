package com.ecommerce.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.ecommerce.Entities.Address;
import com.ecommerce.Entities.Users;
import com.ecommerce.dto.AddressRequestBody;
import com.ecommerce.dto.AddressUpdateRequestBody;
import com.ecommerce.dto.UserUpdateRequestBody;
import com.ecommerce.services.AddressService;
import com.ecommerce.services.UsersService;

@RestController
public class AddressController {
	Logger logger = LoggerFactory.getLogger(AddressController.class);
	@Autowired
	AddressService addressService;

	@Autowired
	UsersService userService;

	@PostMapping("/address/{userId}")
	public ResponseEntity<?> addAddress(@Valid @PathVariable int userId,
			@Valid @RequestBody AddressRequestBody address) {
		try {
			// Check to see if the users does not exists by the user id then show user not
			// exits
			Users checkExisting_User = userService.getUserById(userId);
			if (checkExisting_User == null) {
				logger.info("user not exists with this userId");

				return new ResponseEntity<>("user not exists", HttpStatus.CONFLICT);
			}

			Address add = this.addressService.saveAddress(checkExisting_User, address);
			return new ResponseEntity<>(add, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getalladdress")
	public ResponseEntity<?> getAllAddress() {
		try {
			List<Address> temp = addressService.getAddress();
			if (temp.isEmpty()) {
				logger.info("not found any address");
				return new ResponseEntity<>("Not found any users", HttpStatus.NO_CONTENT);
			}
			logger.info("address found");
			return new ResponseEntity<>(temp, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getaddress/{addressId}")
	public ResponseEntity<?> getOneAddress(@Valid @PathVariable int addressId) {
		Address temp = null;
		try {
			temp = addressService.getOneAddress(addressId);
			logger.info("address details found");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);

		} catch (Exception e) {

			logger.error("Exception occured, {}", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/updateaddress/{addressId}")
	public ResponseEntity<?> updateAddress(@PathVariable int addressId,
			@Valid @RequestBody AddressUpdateRequestBody address) {
		Address temp = null;
		try {
			temp = this.addressService.updateAddress(addressId, address);
			logger.info("address updated successfully");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
		}

	}

	@DeleteMapping("/deleteaddress/{addressId}")
	public ResponseEntity<String> deleteUser(@PathVariable int addressId) {
		try {

			//// Check to see if the address not exists by address id then show address not
			//// found
			Address add = addressService.getOneAddress(addressId);
			if (add == null) {
				logger.info("address not found for this address id");
				return new ResponseEntity<>("address not found for this address id", HttpStatus.BAD_REQUEST);
			}
			addressService.deleteAddress(addressId);
			logger.info("address successfully deleted");
			return new ResponseEntity<String>("address has been deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<String>("address has not been deleted", HttpStatus.NOT_FOUND);

		}

	}

}
