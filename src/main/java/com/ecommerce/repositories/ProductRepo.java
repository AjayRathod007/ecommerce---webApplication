package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.Entities.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {

}
