package com.roger.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books_by_author")
public class BooksByAuthor {
	
	@Id
	@Column(name="idAuthor")
	private int idAuthor;
	
	@Column(name="isbn")
	private String isbn;

	public BooksByAuthor() {

	}

	public int getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
}
