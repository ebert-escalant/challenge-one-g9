package com.library.library_api;

import com.library.library_api.main.Main;
import com.library.library_api.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApiApplication implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(LibraryApiApplication.class, args);
    }
    
    @Override
    public void run(String... args) {
        Main main = new Main(bookService);
        main.execute();
    }
}
