package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.Entities.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
