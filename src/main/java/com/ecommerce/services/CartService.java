package com.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.repositories.CartRepo;

@Service
public class CartService {
	
	@Autowired
	CartRepo cartRepo;

}
