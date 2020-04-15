package com.learn.users.controllers;

import com.learn.users.dto.models.BookDTO;
import com.learn.users.dto.models.UserDTO;
import com.learn.users.services.IBookService;
import com.learn.users.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/books")
@AllArgsConstructor
public class Books {
    private final IBookService bookService;
    private final IUserService userService;

    @GetMapping
    public List<BookDTO> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(path = "/{id}")
    public BookDTO getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/author/{authorId}")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO createBook(@PathVariable Long authorId, @RequestBody @Valid BookDTO book) {
        UserDTO author = userService.getUserById(authorId);

        return bookService.createBook(book, author);
    }
}
