package com.roger.spring.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="books_out_on_loan")
public class BooksOutOnLoan {

	@Id
	@GeneratedValue
	@Column(name="idBookBorrowing")
	private int idBookBorrowing;
	
	@Column(name="borrowedStudentId")
	private int borrowedStudentId;
	
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="data_issued")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataIssued;
	
	@Column(name="data_due_for_return")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDueForReturn;
	
	@Column(name="data_returned")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataReturned;
	
	@Column(name="amount_of_fine", precision=10, scale=2)
	private BigDecimal amountOfFine;

	public BooksOutOnLoan() {

	}

	public int getIdBookBorrowing() {
		return idBookBorrowing;
	}

	public void setIdBookBorrowing(int idBookBorrowing) {
		this.idBookBorrowing = idBookBorrowing;
	}

	public int getBorrowedStudentId() {
		return borrowedStudentId;
	}

	public void setBorrowedStudentId(int borrowedStudentId) {
		this.borrowedStudentId = borrowedStudentId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getDataIssued() {
		return dataIssued;
	}

	public void setDataIssued(Date dataIssued) {
		this.dataIssued = dataIssued;
	}

	public Date getDataDueForReturn() {
		return dataDueForReturn;
	}

	public void setDataDueForReturn(Date dataDueForReturn) {
		this.dataDueForReturn = dataDueForReturn;
	}

	public Date getDataReturned() {
		return dataReturned;
	}

	public void setDataReturned(Date dataReturned) {
		this.dataReturned = dataReturned;
	}

	public BigDecimal getAmountOfFine() {
		return amountOfFine;
	}

	public void setAmountOfFine(BigDecimal amountOfFine) {
		this.amountOfFine = amountOfFine;
	}
	
	
}
