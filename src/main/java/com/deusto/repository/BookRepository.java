package com.deusto.repository;

import com.deusto.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface BookRepository extends MongoRepository<Book,String>{

}
