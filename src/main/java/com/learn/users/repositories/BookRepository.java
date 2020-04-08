package com.learn.users.repositories;
import com.learn.users.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllBooksByUserId(String userId);
}
