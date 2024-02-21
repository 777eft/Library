package com.libraryApp.Library.repository;

import com.libraryApp.Library.libraryitem.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {
    List<Book> findBooksByTitleIgnoreCase(String title);

    List<Book> findBooksByReleaseYear(int releaseYear);

    List<Book> findBooksByAuthorIgnoreCase(String author);

    List<Book> findBooksByGenreIgnoreCase(String genre);

    Book findBookByIsbn(int isbn);

}