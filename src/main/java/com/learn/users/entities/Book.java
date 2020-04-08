package com.learn.users.entities;

import com.learn.users.dto.models.UserDTO;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "book_id", nullable = false, updatable = false, unique = true)
    private String bookId;

    @Column(name = "user_id", nullable = false, updatable = false, unique = true)
    private String userId;
}
