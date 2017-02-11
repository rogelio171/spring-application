package com.roger.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roger.spring.model.Book;

public interface BookRepository extends JpaRepository<Book, String> {

	List<Book> findByTitle(String title);
	
}
