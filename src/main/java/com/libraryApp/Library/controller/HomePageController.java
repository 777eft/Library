package com.libraryApp.Library.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class HomePageController {

    @GetMapping()
    public String homePage() {
        return "Library Home Page";
    }
}
