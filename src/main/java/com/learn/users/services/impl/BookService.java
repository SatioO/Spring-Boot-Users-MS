package com.learn.users.services.impl;

import com.learn.users.dto.mappers.BookMapper;
import com.learn.users.dto.mappers.OrderMapper;
import com.learn.users.dto.mappers.SectionMapper;
import com.learn.users.dto.mappers.UserMapper;
import com.learn.users.dto.models.BookDTO;
import com.learn.users.dto.models.SectionDTO;
import com.learn.users.dto.models.UserDTO;
import com.learn.users.entities.Book;
import com.learn.users.exceptions.BookNotFoundException;
import com.learn.users.repositories.BookRepository;
import com.learn.users.services.IBookService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Service
public class BookService implements IBookService {
    private final BookRepository bookRepository;

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(book -> BookMapper.toBookDTO(book)
                        .setSections(book.getSections()
                                .stream()
                                .map(SectionMapper::toSectionDTO)
                                .collect(Collectors.toSet())))
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookById(Long id) throws BookNotFoundException {
        Book bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found: " + id));
        return BookMapper.toBookDTO(bookEntity);
    }

    @Override
    public BookDTO createBook(BookDTO book) {
        return BookMapper.toBookDTO(bookRepository.save(BookMapper
                .toBookEntity(book)));
    }

    @Override
    public BookDTO attachSections(Set<SectionDTO> sections, BookDTO book) {
        Book bookEntity = BookMapper
                .toBookEntity(book)
                .setSections(sections
                        .stream()
                        .map(SectionMapper::toSectionEntity)
                        .collect(Collectors.toSet())
                );

        return BookMapper.toBookDTO(bookRepository.save(bookEntity));
    }
}
