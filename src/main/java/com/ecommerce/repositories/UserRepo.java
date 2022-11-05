package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.Entities.Users;


public interface UserRepo extends JpaRepository<Users, Integer> {

}
