package com.libraryApp.Library.service;

import com.libraryApp.Library.libraryitem.Book;
import com.libraryApp.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(String title, int releaseYear, String author, String genre, int isbn) {
        Book book = new Book(title, releaseYear, author, genre, isbn);
        bookRepository.insert(book);

        return book;
    }

    public Book deleteBook(int isbn) {
        Book bookToDelete = findSingleBook(isbn);
        bookRepository.findBookByIsbn(isbn);

        return bookToDelete;
    }

    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public Book findSingleBook(int isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }

    public void saveBook(Book book) {
        Book bookToReplace = bookRepository.findBookByIsbn(book.getIsbn());
        bookRepository.delete(bookToReplace);
        bookRepository.save(book);
    }

}
