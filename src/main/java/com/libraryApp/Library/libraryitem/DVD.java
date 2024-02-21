package com.libraryApp.Library.libraryitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dvds")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DVD {

    @Id
    private ObjectId id;

    private String title;

    private int releaseYear;

    private int durationInMinutes;

    public DVD(String title, int releaseYear, int durationInMinutes) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.durationInMinutes = durationInMinutes;
    }
}