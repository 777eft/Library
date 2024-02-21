package com.libraryApp.Library.controller;

import com.libraryApp.Library.libraryitem.Book;
import com.libraryApp.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add-book")
    public ResponseEntity<Book> createBook(@RequestBody Book bookToAdd) {
        Book book = bookService.addBook(
                bookToAdd.getTitle(),
                bookToAdd.getReleaseYear(),
                bookToAdd.getAuthor(),
                bookToAdd.getGenre(),
                bookToAdd.getIsbn()
        );
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-book/{isbn}")
    public ResponseEntity<Optional<Book>> deleteBook(@PathVariable int isbn) {
        return new ResponseEntity<>(bookService.deleteBook(isbn), HttpStatus.OK);
    }


    @GetMapping("/all-books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.allBooks(), HttpStatus.OK);
    }

    @GetMapping("/search/{isbn}")
    public ResponseEntity<Optional<Book>> searchByIsbn(@PathVariable int isbn) {
        return new ResponseEntity<>(bookService.findSingleBook(isbn), HttpStatus.OK);
    }

}
