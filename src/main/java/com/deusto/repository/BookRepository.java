package com.deusto.repository;

import com.deusto.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface BookRepository extends MongoRepository<Book,String>{
	List<Book> findByTitle(String title);
//	List<Book> findByAuthor(String authorFirstName);
}
