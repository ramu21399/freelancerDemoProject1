package com.freelancer.bookcontroller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelancer.dto.BookDto;
import com.freelancer.model.Book;
import com.freelancer.service.IBookService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {

	private IBookService iBookService;
	@Autowired
    private Environment env;

	public BookController(IBookService iBookService) {
		this.iBookService = iBookService;
	}

	@PostMapping("/v1/add")
	public ResponseEntity<String> addBook(@Valid @RequestBody BookDto bookDto) {
		
		
		System.out.println( System.getProperty("java.version"));
		
		log.info("Rest controller  stating the application");

		ModelMapper mapper = new ModelMapper();

		

		 Book entity = mapper.map(bookDto, Book.class);
		log.info("Invoking the service class method ");
		entity = iBookService.addBook(entity);
		
		
		 

		
		 BookDto dto = mapper.map(entity, BookDto.class);
		log.info("mapped entity object to dto object");
		
		

		String bookId = env.getProperty("book.Id") + dto.getBookId();

		return new ResponseEntity<>(bookId, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<BookDto>> getAll() {

		ModelMapper mapper = new ModelMapper();
		List<Book> books = iBookService.getAllBooks();

		List<BookDto> booksDto = books.stream().map(book -> mapper.map(book, BookDto.class)).toList();

		return new ResponseEntity<>(booksDto, HttpStatus.OK);

	}

	
	  @GetMapping("/{id}") public ResponseEntity<BookDto> getById(@PathVariable
	  Long id) {
	  
	  ModelMapper mapper = new ModelMapper();
	  
	  Book book = iBookService.getBookById(id);
	  
	  return new ResponseEntity<>(mapper.map(book, BookDto.class), HttpStatus.OK);
	  
	  }
	  
	  @DeleteMapping("/{id}") public ResponseEntity<String>
	  deleteByID(@PathVariable Long id) {
	  
	  
	  
	  return new ResponseEntity<>(iBookService.deleteByID(id), HttpStatus.OK); }
	 

}
