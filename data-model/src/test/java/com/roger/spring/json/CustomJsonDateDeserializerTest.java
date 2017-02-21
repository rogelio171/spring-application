package com.roger.spring.json;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.roger.spring.model.Book;

public class CustomJsonDateDeserializerTest {
	private static final String ISBN_TEST = "12345678910111";
	private static final String TITLE = "JUnit 4";
	
	@Test
	public void testCustomJsonDateDeserializer() throws JsonProcessingException, ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		String dateAsString = "21/02/2017";
		Date date = formatter.parse(dateAsString);
		
		Book book = new Book();
		book.setIsbn(ISBN_TEST);
		book.setTitle(TITLE);
		book.setDateOfPublication(date);
		
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(book);
		
		assertThat(result, containsString(dateAsString));
		
	}

}
