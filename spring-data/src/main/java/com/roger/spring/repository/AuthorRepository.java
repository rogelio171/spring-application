package com.roger.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roger.spring.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	
	List<Author> findByLastName(String lastName);
	
}
