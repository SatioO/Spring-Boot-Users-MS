package com.learn.users.dto.mappers;

import com.learn.users.dto.models.BookDTO;
import com.learn.users.entities.Book;
import com.learn.users.entities.User;

import java.util.stream.Collectors;

public class BookMapper {
    public static BookDTO toBookDTO(Book book) {
        return new BookDTO()
                .setId(book.getId())
                .setName(book.getName())
                .setDescription(book.getDescription())
                .setPrice(book.getPrice())
                .setPublishedOn(book.getPublishedOn())
                .setAuthors(book.getAuthors().stream()
                        .map(UserMapper::toUserDTO).collect(Collectors.toSet()));
    }

    public static Book toBookEntity(BookDTO book) {
        return new Book()
                .setId(book.getId())
                .setName(book.getName())
                .setDescription(book.getDescription())
                .setPrice(book.getPrice())
                .setPublishedOn(book.getPublishedOn())
                .setAuthors(book.getAuthors().stream()
                        .map(UserMapper::toUserEntity).collect(Collectors.toSet()));
    }
}
