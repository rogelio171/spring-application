package com.roger.spring.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * The persistent class for the books database table.
 * 
 */
@Entity
@Table(name="books")
@NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = ?1")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "isbn", unique = true, nullable = false, length = 14)
    private String isbn;

    @Column(name = "title", nullable = false)
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_publication")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date dateOfPublication;

	//bi-directional many-to-many association to Author
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "books", cascade = CascadeType.ALL)
    private Set<Author> authors = new HashSet<Author>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "books_by_category", joinColumns = {
        @JoinColumn(name = "isbn", nullable = false, updatable = false) }, inverseJoinColumns = {
        @JoinColumn(name = "idCategory", nullable = false, updatable = false) })
    private Set<Category> categories = new HashSet<Category>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book", cascade = CascadeType.ALL)
    private Set<BooksOutOnLoan> booksOutOnLoan = new HashSet<BooksOutOnLoan>();

	public Book() {
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getDateOfPublication() {
		return this.dateOfPublication;
	}

	public void setDateOfPublication(Date dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<BooksOutOnLoan> getBooksOutOnLoans() {
		return this.booksOutOnLoan;
	}

	public void setBooksOutOnLoans(Set<BooksOutOnLoan> booksOutOnLoans) {
		this.booksOutOnLoan = booksOutOnLoans;
	}

	public BooksOutOnLoan addBooksOutOnLoan(BooksOutOnLoan booksOutOnLoan) {
		getBooksOutOnLoans().add(booksOutOnLoan);
		booksOutOnLoan.setBook(this);

		return booksOutOnLoan;
	}

	public BooksOutOnLoan removeBooksOutOnLoan(BooksOutOnLoan booksOutOnLoan) {
		getBooksOutOnLoans().remove(booksOutOnLoan);
		booksOutOnLoan.setBook(null);

		return booksOutOnLoan;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", dateOfPublication=" + dateOfPublication + ", authors="
				+ authors + "]";
	}
	
	

}