package com.libraryApp.Library.libraryitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "newspapers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Newspaper {

    @Id
    private ObjectId id;

    private String title;

    private int releaseYear;

    private String countryPublished;

    public Newspaper(String title, int releaseYear, String countryPublished) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.countryPublished = countryPublished;
    }
}
