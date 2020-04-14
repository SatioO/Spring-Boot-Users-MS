package com.learn.users.dto.mappers;

import com.learn.users.dto.models.BookDTO;
import com.learn.users.entities.Book;

public class BookMapper {
    public static BookDTO toBookDTO(Book book) {
        return new BookDTO()
                .id(book.id())
                .name(book.name())
                .description(book.description())
                .price(book.price())
                .publishedOn(book.publishedOn());
    }

    public static Book toBookEntity(BookDTO book) {
        return new Book()
                .id(book.id())
                .name(book.name())
                .description(book.description())
                .price(book.price())
                .publishedOn(book.publishedOn());
    }
}
