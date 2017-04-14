package com.deusto.services;

import com.deusto.models.Book;
import com.deusto.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bRepository;

    public Book insert(Book book) {
        bRepository.insert(book);
        return book;
    }

    public List<Book> findAll() {
        return bRepository.findAll();
    }

    public Book findById(String id) {
        return bRepository.findById(id);
    }

    public List<Book> findByAuthorFirsName(String firstName) {
        return bRepository.findAllByAuthorLastName(firstName);
    }

    public List<Book> findByGenre(String genre) {
        return bRepository.findAllByGenre(genre);
    }

    public List<Book> findByTitle(String title) {
        return bRepository.findByTitle(title);
    }

    public void update(Book registr) {
        bRepository.save(registr);
    }


}
