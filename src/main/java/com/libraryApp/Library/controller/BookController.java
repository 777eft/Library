package com.libraryApp.Library.controller;

import com.libraryApp.Library.libraryitem.Book;
import com.libraryApp.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add-book")
    public Book createBook(@RequestBody Book bookToAdd) {
        Book book = bookService.addBook(
                bookToAdd.getTitle(),
                bookToAdd.getReleaseYear(),
                bookToAdd.getAuthor(),
                bookToAdd.getGenre(),
                bookToAdd.getIsbn()
        );
        return book;
    }

    @DeleteMapping("/delete-book/{isbn}")
    public Book deleteBook(@PathVariable int isbn) {
        return bookService.deleteBook(isbn);
    }

    @GetMapping("/all-books")
    public List<Book> getAllBooks() {
        return bookService.allBooks();
    }

    @GetMapping("/search/{isbn}")
    public Book searchByIsbn(@PathVariable int isbn) {
        return bookService.findSingleBook(isbn);
    }

    @PutMapping({"/borrow-book/{isbn}", "/return-book/{isbn}"})
    public Book borrowOrReturnBook(@PathVariable int isbn) {
        Book borrowedOrReturnedBook = bookService.findSingleBook(isbn);

        if (borrowedOrReturnedBook == null) {
            return null;
        }

        borrowedOrReturnedBook.setAvailableForBorrow(!borrowedOrReturnedBook.isAvailableForBorrow());

        bookService.saveBook(borrowedOrReturnedBook);

        return bookService.findSingleBook(isbn);
    }
}
