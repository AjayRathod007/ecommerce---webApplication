package com.ecommerce.services;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Entities.Address;
import com.ecommerce.Entities.Users;
import com.ecommerce.dto.AddressRequestBody;
import com.ecommerce.dto.AddressUpdateRequestBody;
import com.ecommerce.repositories.AddressRepo;

@Service
@Transactional
public class AddressService {

	@Autowired
	AddressRepo addressRepo;

	public Address saveAddress(Users checkExisting_User, AddressRequestBody address) {
		Address ad = new Address();
		ad.setCity(address.getCity());
		ad.setHouseNumber(address.getHouseNumber());
		ad.setPincode(address.getPincode());
		ad.setStreet(address.getStreet());
		ad.setCreatedAt(new Date());
		ad.setUpdatedAt(new Date());
		//ad.setUser(checkExisting_User);
		return addressRepo.save(ad);
	}

	public List<Address> getAddress() {

		return addressRepo.findAll();
	}

	public Address getOneAddress(@Valid int addressId) {
		return addressRepo.findById(addressId)
				.orElseThrow(() -> new NoSuchElementException("NO ADDRESS PRESENT WITH ID = " + addressId));
	}

	public Address updateAddress(int addressId, @Valid AddressUpdateRequestBody address) {
		Address temp = addressRepo.findById(addressId).get();
		temp.setCity(address.getCity());
		temp.setHouseNumber(address.getHouseNumber());
		temp.setStreet(address.getStreet());
		temp.setPincode(address.getPincode());
		temp.setUpdatedAt(address.getUpdatedAt());
		return addressRepo.save(temp);
	}

	public void deleteAddress(int addressId) {
		// TODO Auto-generated method stub
		Address temp = addressRepo.findById(addressId).get();
		addressRepo.delete(temp);

	}

}
