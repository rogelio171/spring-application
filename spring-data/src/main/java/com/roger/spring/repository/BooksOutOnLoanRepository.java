package com.roger.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roger.spring.model.BooksOutOnLoan;
import com.roger.spring.model.Student;

public interface BooksOutOnLoanRepository extends JpaRepository<BooksOutOnLoan, Long> {
	
	List<BooksOutOnLoan> findByStudent(Student student);

}
