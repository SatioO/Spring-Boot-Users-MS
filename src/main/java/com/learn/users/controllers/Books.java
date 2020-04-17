package com.learn.users.controllers;

import com.learn.users.dto.models.BookDTO;
import com.learn.users.dto.models.SectionDTO;
import com.learn.users.dto.models.UserDTO;
import com.learn.users.services.IBookService;
import com.learn.users.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "books")
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO createBook(@RequestBody @Valid BookDTO book) {
        Set<UserDTO> users = userService.getUsersByIds(book.getAuthorIds());
        return bookService.createBook(book.setAuthors(users));
    }

    @PutMapping("/add/{bookId}/sections")
    public BookDTO attachSections(@PathVariable Long bookId, @RequestBody Map<String, List<SectionDTO>> data) {
        List<SectionDTO> sections = data.get("sections");
        BookDTO book = bookService.getBookById(bookId).setSections(sections);
        return bookService.attachSections(book);
    }
}
