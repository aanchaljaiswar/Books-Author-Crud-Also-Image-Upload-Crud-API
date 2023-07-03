package com.devtool.test.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devtool.test.Entity.Book;

@Repository
public interface BookDao extends CrudRepository<Book,Integer> {

	public Book findById(int id);
}
