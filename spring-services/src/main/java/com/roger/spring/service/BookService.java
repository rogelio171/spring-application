package com.roger.spring.service;

import java.util.List;

import com.roger.spring.model.Book;

public interface BookService {
	
	List<Book> findByTitle(String title);

}
