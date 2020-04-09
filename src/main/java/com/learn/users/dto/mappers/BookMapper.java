package com.learn.users.dto.mappers;

import com.learn.users.dto.models.BookDTO;
import com.learn.users.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public static BookDTO toBookDTO(Book book) {
        return new BookDTO()
                .setId(book.getId())
                .setName(book.getName())
                .setDescription(book.getDescription())
                .setPrice(book.getPrice())
                .setPublishedOn(book.getPublishedOn());
    }

    public static Book toBookEntity(BookDTO book) {
        return new Book()
                .setId(book.getId())
                .setName(book.getName())
                .setDescription(book.getDescription())
                .setPrice(book.getPrice())
                .setPublishedOn(book.getPublishedOn());
    }
}
