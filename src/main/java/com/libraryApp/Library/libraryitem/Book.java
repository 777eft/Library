package com.libraryApp.Library.libraryitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    private ObjectId id;

    private String title;

    private int releaseYear;

    private String author;

    private String genre;

    private int isbn;

    private boolean availableForBorrow;

    public Book(String title, int releaseYear, String author, String genre, int isbn) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.availableForBorrow = true;
    }


}
