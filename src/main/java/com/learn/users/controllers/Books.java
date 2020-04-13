package com.learn.users.controllers;

import com.learn.users.dto.models.BookDTO;
import com.learn.users.services.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/books")
public class Books {
    private final IBookService bookService;

    @GetMapping
    public List<BookDTO> findAll() {
        return bookService.getAllBooks();
    }

    @GetMapping(path = "/{id}")
    public BookDTO findById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO save(@RequestBody @Valid BookDTO book) {

        return bookService.createBook(book);
    }
}
