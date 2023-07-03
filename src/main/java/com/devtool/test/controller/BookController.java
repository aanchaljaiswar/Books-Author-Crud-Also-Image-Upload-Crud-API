package com.devtool.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import com.devtool.test.Entity.Book;
import com.devtool.test.service.BookService;

@RestController
//@Controller
public class BookController {
	//@RequestMapping(value="/books",method=RequestMethod.GET)
	//@ResponseBody
	
//	@GetMapping("/books")
//	public Book getBooks() {
//		Book book =new Book();
//		book.setId(1234);
//		book.setTitle("Java Book");
//		book.setAuthors("XYz");
//		return book;}
	
	@Autowired
	private BookService bookService;
	

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks()
	{
		List<Book> list = bookService.getallBooks();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id )
	{   
		Book b = bookService.getBookById(id);
		if(b==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	return ResponseEntity.of(Optional.of(b));
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book)
	{   Book b = null;
	
	try {
		b = this.bookService.addBook(book);
		System.out.println(book);
		return ResponseEntity.of(Optional.of(b));
		}
	catch(Exception e)
	{
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
		
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id)
	{ 
		try {
			//calling method from services
			this.bookService.deleteBookById(id);
			System.out.println("Deleted ID " + id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Id Not Found " + id);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id")int id,@RequestBody Book book)
	{   
		try
		{
			this.bookService.updateBook(book ,id);
			return ResponseEntity.ok().body(book);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
}
