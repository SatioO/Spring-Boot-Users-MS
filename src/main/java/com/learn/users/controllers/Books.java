package com.learn.users.controllers;

import com.learn.users.dto.models.BookDTO;
import com.learn.users.services.IBookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class Books {
    IBookService bookService;

    public Books(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDTO> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(path = "/{id}")
    public BookDTO getBook(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO createBook(@RequestBody @Valid BookDTO book) {
        return bookService.createBook(book);
    }
}
