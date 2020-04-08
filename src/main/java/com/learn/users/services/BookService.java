package com.learn.users.services;

import com.learn.users.dto.mappers.BookMapper;
import com.learn.users.dto.models.BookDTO;
import com.learn.users.entities.Book;
import com.learn.users.exceptions.BookNotFoundException;
import com.learn.users.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<BookDTO> getAllBooks() {
        List<BookDTO> books = bookRepository.findAll().stream().map(BookMapper::toBookDTO).collect(Collectors.toList());
        return books;
    }

    @Override
    public BookDTO getBookById(Long id) throws BookNotFoundException {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found: " + id));
        return BookMapper.toBookDTO(book);
    }
}
