package com.deusto.repositories;

import org.springframework.stereotype.Repository;

import com.deusto.models.Book;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface BookRepository extends MongoRepository<Book,String>{
	Book findById(String id);
	List<Book> findByTitle(String title);
	List<Book> findByAuthorFirstName(String authorFirstName);
	List<Book> findAllByAuthorLastName(String authorLastName);
	List<Book> findAllByGenre(String genre);
}
