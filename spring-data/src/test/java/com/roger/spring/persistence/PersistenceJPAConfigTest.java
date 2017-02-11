package com.roger.spring.persistence;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.roger.spring.repository.BookRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceJPAConfig.class)
public class PersistenceJPAConfigTest {
	
	@Autowired
	protected BookRepository bookRepository;
	
	@Test
	public void instanceInjectedTest( ) {
		Assert.assertNotNull(bookRepository);
	}

}
