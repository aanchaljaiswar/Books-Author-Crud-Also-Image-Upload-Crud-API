package com.devtool.test.service;

//import java.util.ArrayList;
//import java.util.stream.Collectors;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtool.test.Dao.BookDao;
import com.devtool.test.Entity.Book;

@Component

public class BookService {
	
	@Autowired
	private BookDao bookDao;

	//fake service without DB
	
//	private static List<Book> list=new ArrayList<>();
//	
//	static
//	{
//	list.add(new Book(12,"Java Book","ABc"));
//	list.add(new Book(15,"Python Book","DEF"));
//	list.add(new Book(22,"Spring Book","LMN"));
//	
//	}
	
	
	
	
	//GET ALL BOOK
	public List<Book> getallBooks()
	{
		List<Book> list=(List<Book>)this.bookDao.findAll();
		//System.out.println( list);
		return list;
		
	}
	
	//get Single Book by Id
	public Book getBookById(int id)
	{
		Book book=null;
		try {
		//book=list.stream().filter(e->e.getId()==id).findFirst().get();
		book = this.bookDao.findById(id);
		if(book!=null) {
		System.out.println("Book ID " + id +"\n" + "Details " + book);}
		else {System.out.println("Book ID Not Found " + id);}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("An error occurred while fetching book with ID: " + id);
		}
		return book;
		
	}
	
	//adding book
	public Book addBook(Book b)
	{ 
		Book res= bookDao.save(b);
		//list.add(b);
		return res;
	}
	
	//deleting book
	public void deleteBookById(int bid)
	{  
	
		//list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
		bookDao.deleteById(bid);
	}
	
	//update book
	
	public void updateBook(Book book,int id )
	{
//		list=list.stream().map(b -> {
//			if (b.getId()==id)
//			{
//				b.setTitle(book.getTitle());
//				b.setAuthors(book.getAuthors());
//			}
//			return b;
//		}).collect(Collectors.toList());
		book.setId(id);
		bookDao.save(book);
	}
}
