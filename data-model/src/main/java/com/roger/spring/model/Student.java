package com.roger.spring.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the students database table.
 * 
 */
@Entity
@Table(name="students")
@NamedQuery(name="Student.findAll", query = "SELECT s FROM Student s WHERE s.firstName = ?1")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idStudent", unique = true, nullable = false)
	private int idStudent;

	@Column(name = "email_adress", unique = true, length = 45)
	private String emailAdress;

	@Column(name = "firstName", nullable = false, length = 100)
	private String firstName;

	@Column(name = "lastName", nullable = false, length = 100)
	private String lastName;

	@Column(name = "phone_number", length = 25)
	private String phoneNumber;

	@Column(name="student_adress")
	private String studentAdress;

	//bi-directional many-to-one association to BooksOutOnLoan
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL)
    private Set<BooksOutOnLoan> booksOutOnLoans = new HashSet<BooksOutOnLoan>();

	public Student() {
	}

	public int getIdStudent() {
		return this.idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public String getEmailAdress() {
		return this.emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStudentAdress() {
		return this.studentAdress;
	}

	public void setStudentAdress(String studentAdress) {
		this.studentAdress = studentAdress;
	}

	public Set<BooksOutOnLoan> getBooksOutOnLoans() {
		return this.booksOutOnLoans;
	}

	public void setBooksOutOnLoans(Set<BooksOutOnLoan> booksOutOnLoans) {
		this.booksOutOnLoans = booksOutOnLoans;
	}

	public BooksOutOnLoan addBooksOutOnLoan(BooksOutOnLoan booksOutOnLoan) {
		getBooksOutOnLoans().add(booksOutOnLoan);
		booksOutOnLoan.setStudent(this);

		return booksOutOnLoan;
	}

	public BooksOutOnLoan removeBooksOutOnLoan(BooksOutOnLoan booksOutOnLoan) {
		getBooksOutOnLoans().remove(booksOutOnLoan);
		booksOutOnLoan.setStudent(null);

		return booksOutOnLoan;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", studentAdress=" + studentAdress + ", emailAdress=" + emailAdress + "]";
	}
	
	

}