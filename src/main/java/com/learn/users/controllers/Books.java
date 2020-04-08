package com.learn.users.controllers;

import com.learn.users.dto.models.BookDTO;
import com.learn.users.exceptions.BookNotFoundException;
import com.learn.users.exceptions.ResourceNotFoundException;
import com.learn.users.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class Books {
    @Autowired
    IBookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BookDTO> getBook(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(id));
        } catch (BookNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @GetMapping(path = "/user/{userId}")
    public ResponseEntity<List<BookDTO>> getBooksByUserId(@PathVariable String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody @Valid BookDTO book) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.createBook(book));
    }
}
