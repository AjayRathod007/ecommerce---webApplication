package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.Entities.Cart;

public interface CartRepo extends JpaRepository<Cart,Integer>{

}
