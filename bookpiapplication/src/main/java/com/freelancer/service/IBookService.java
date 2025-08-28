package com.freelancer.service;

import java.util.List;
import java.util.Optional;

import com.freelancer.model.Book;

public interface IBookService {
	
	
	public Book addBook(Book book);
	public List<Book> getAllBooks();
	public Book getBookById(Long Id);
	public String deleteByID(Long id);
	

}
