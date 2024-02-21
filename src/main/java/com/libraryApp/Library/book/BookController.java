package com.libraryApp.Library.book;

import org.bson.types.ObjectId;
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

    @GetMapping("/all-books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<List<Book>>(bookService.allBooks(), HttpStatus.OK);
    }

    @GetMapping("/search/{isbn}")
    public ResponseEntity<Optional<Book>> searchByIsbn(@PathVariable int isbn) {
        return new ResponseEntity<Optional<Book>>(bookService.findSingleBook(isbn), HttpStatus.OK);
    }

}
