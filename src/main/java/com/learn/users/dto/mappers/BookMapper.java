package com.learn.users.dto.mappers;

import com.learn.users.dto.models.BookDTO;
import com.learn.users.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public static BookDTO toBookDTO(Book book) {
        return new BookDTO().setName(book.getName()).setBookId(book.getBookId()).setUserId(book.getUserId());
    }
}