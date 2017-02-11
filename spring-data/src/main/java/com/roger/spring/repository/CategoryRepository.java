package com.roger.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roger.spring.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	List<Category> findByName(String name);

}
