package com.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.services.CartService;
import com.ecommerce.services.ProductService;

@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@Autowired
	ProductService productService;

}
