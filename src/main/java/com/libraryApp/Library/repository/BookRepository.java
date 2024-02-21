package com.libraryApp.Library.repository;

import com.libraryApp.Library.libraryitem.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {
    Book findBookByIsbn(int isbn);

}