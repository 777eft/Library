package com.libraryApp.Library.book;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(String title, int releaseYear, String author, String genre, int isbn) {

        Book book = new Book(title, releaseYear, author, genre, isbn);
        bookRepository.insert(book);

        return book;
    }

    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> findSingleBook(int isbn) {
        return bookRepository.findByIsbn(isbn);
    }

}
