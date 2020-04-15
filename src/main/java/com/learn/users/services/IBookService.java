package com.learn.users.services;

import com.learn.users.dto.models.BookDTO;
import com.learn.users.dto.models.UserDTO;
import com.learn.users.exceptions.BookNotFoundException;
import java.util.List;

public interface IBookService {
    List<BookDTO> getAllBooks();

    BookDTO getBookById(Long id) throws BookNotFoundException;

    BookDTO createBook(BookDTO book, UserDTO author);
}
