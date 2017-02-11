package com.roger.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the books_out_on_loan database table.
 * 
 */
@Entity
@Table(name="books_out_on_loan")
@NamedQuery(name = "BooksOutOnLoan.findByStudent", query = "SELECT b FROM BooksOutOnLoan b WHERE b.student.idStudent = ?1")
public class BooksOutOnLoan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBookBorrowing", unique = true, nullable = false)
    private Integer idBookBorrowing;

	@Column(name = "amount_of_fine", precision = 10, scale = 2)
    private BigDecimal amountOfFine;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_due_for_return", length = 0)
    private Date dataDueForReturn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_issued")
	private Date dataIssued;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_returned", length = 0)
    private Date dataReturned;

	//bi-directional many-to-one association to Book
	@ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "isbn")
    private Book book;

	//bi-directional many-to-one association to Student
	@ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "borrowerStudent_id", nullable = false)
    private Student student;

	public BooksOutOnLoan() {
	}

	public int getIdBookBorrowing() {
		return this.idBookBorrowing;
	}

	public void setIdBookBorrowing(int idBookBorrowing) {
		this.idBookBorrowing = idBookBorrowing;
	}

	public BigDecimal getAmountOfFine() {
		return this.amountOfFine;
	}

	public void setAmountOfFine(BigDecimal amountOfFine) {
		this.amountOfFine = amountOfFine;
	}

	public Date getDataDueForReturn() {
		return this.dataDueForReturn;
	}

	public void setDataDueForReturn(Date dataDueForReturn) {
		this.dataDueForReturn = dataDueForReturn;
	}

	public Date getDataIssued() {
		return this.dataIssued;
	}

	public void setDataIssued(Date dataIssued) {
		this.dataIssued = dataIssued;
	}

	public Date getDataReturned() {
		return this.dataReturned;
	}

	public void setDataReturned(Date dataReturned) {
		this.dataReturned = dataReturned;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "BooksOutOnLoan [idBookBorrowing=" + idBookBorrowing + ", student=" + student + ", book=" + book
				+ ", dataIssued=" + dataIssued + ", dataDueForReturn=" + dataDueForReturn + ", dataReturned="
				+ dataReturned + ", amountOfFine=" + amountOfFine + "]";
	}

}