package com.book.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.exception.ResourceNotFoundException;
import com.book.model.Book;
import com.book.repository.BookRepository;



@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	//get all books
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	//create book rest api
	@PostMapping("/books")
	public Book CreateBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	//get book by id rest api
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id) {
		
		Book book = bookRepository.findById(id)
				.orElseThrow(() ->new ResourceNotFoundException("Book not exist with id:"+id));
		return ResponseEntity.ok(book);
	}
	
	//update book rest api
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id,@RequestBody Book bookDetails){
		Book book = bookRepository.findById(id)
				.orElseThrow(() ->new ResourceNotFoundException("Book not exist with id:"+id));
		
		book.setName(bookDetails.getName());
		book.setAuthor(bookDetails.getAuthor());
		book.setgenre(bookDetails.getgenre());
		book.setAvailability(bookDetails.getAvailability());
		
		Book updatedBook = bookRepository.save(book);
		return ResponseEntity.ok(updatedBook);
	}
	//delete book rest api
	@DeleteMapping("books/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteBook(@PathVariable Long id){
		Book book = bookRepository.findById(id)
				.orElseThrow(() ->new ResourceNotFoundException("Book not exist with id:"+id));
		
		bookRepository.delete(book);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
