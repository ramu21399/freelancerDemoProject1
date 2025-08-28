package com.freelancer.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.freelancer.constants.ErrorCodeEnum;
import com.freelancer.excetionhandling.BookNotFoundException;
import com.freelancer.model.Book;
import com.freelancer.repositiory.BookRepository;
import com.freelancer.service.IBookService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookServiceImpl implements IBookService {

	private BookRepository bookRepository;
	
	@Autowired
    private Environment env;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Book addBook(Book book) {
		log.info("adding the book to Db");
		
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		log.info("fetching the all the books present in the Db");
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(Long id) {

		Optional<Book> op = bookRepository.findById(id);

		if (op.isPresent()) {
			log.info("fetching the book by id");
			return op.get();
		} else {
			log.error("book not found exception");
			throw new BookNotFoundException(ErrorCodeEnum.BOOK_NOT_FOUND.getErrorCode(),
					ErrorCodeEnum.BOOK_NOT_FOUND.getErrorMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public String deleteByID(Long id) {
		Optional<Book> op = bookRepository.findById(id);
		
		if (op.isPresent()) {
			log.info("fetching the book by id");
			bookRepository.delete(op.get());
			return  env.getProperty("book.deleted.success");
		} else {
			log.error("Book not found excetion in delete method");
			throw new BookNotFoundException(ErrorCodeEnum.BOOK_NOT_FOUND_TO_DELETE.getErrorCode(),
					ErrorCodeEnum.BOOK_NOT_FOUND_TO_DELETE.getErrorMessage(), HttpStatus.NOT_FOUND);
		}
		
		
		
		
		
		
	}

}
