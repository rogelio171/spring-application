package com.roger.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roger.spring.model.Book;
import com.roger.spring.repository.BookRepository;
import com.roger.spring.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> findByTitle(String title) {
		return bookRepository.findByTitle(title);
	}

	
}
