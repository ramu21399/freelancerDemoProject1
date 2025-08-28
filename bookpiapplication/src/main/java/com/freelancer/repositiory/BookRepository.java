package com.freelancer.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freelancer.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	

}
