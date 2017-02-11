package com.roger.spring.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.roger.spring.model.Book;
import com.roger.spring.persistence.PersistenceJPAConfigTest;

public class BookRepositoryTest extends PersistenceJPAConfigTest {

	@Test
    public void count(){
        long numberBooks = bookRepository.count();
        System.out.println("Number of books: " + numberBooks);
        Assert.assertTrue(numberBooks >= 0);
    }

	@Test
	public void findAllBooks(){		
		List<Book> books = bookRepository.findAll();
		Assert.assertTrue(books.isEmpty());
	}

}
