package com.devtool.test.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;


@Entity
@Table(name="books")
public class Book {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JsonManagedReference
	private Authors authors;
	
	public Book(int id, String title, Authors authors) {
		super();
		this.id = id;
		this.title = title;
		this.authors = authors;
	}

	public Book() {
		super();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Authors getAuthors() {
		return authors;
	}

	public void setAuthors(Authors authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authors=" + authors + "]";
	}
	
}
