package com.roger.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books_by_category")
public class BooksByCategory {

	@Id
	@Column(name="idCategory")
	public int idCategory;
	
	@Column(name="isbn")
	public String isbn;
	
	public BooksByCategory() {
		
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
}
