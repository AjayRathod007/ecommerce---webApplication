package com.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.Entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	List<Category> findByCategoryName(String categoryName);
	

}
