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
        Book bookToDelete = findBookByIsbn(isbn);
        bookRepository.findBookByIsbn(isbn);

        return bookToDelete;
    }

    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findBooksByTitleIgnoreCase(title);
    }

    public List<Book> findBooksByReleaseYear(int releaseYear) {
        return bookRepository.findBooksByReleaseYear(releaseYear);
    }

    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findBooksByAuthorIgnoreCase(author);
    }

    public List<Book> findBooksByGenre(String genre) {
        return bookRepository.findBooksByGenreIgnoreCase(genre);
    }

    public Book findBookByIsbn(int isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }

    public void saveBook(Book book) {
        Book bookToReplace = bookRepository.findBookByIsbn(book.getIsbn());
        bookRepository.delete(bookToReplace);
        bookRepository.save(book);
    }

}
