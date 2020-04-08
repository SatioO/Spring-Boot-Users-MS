package com.learn.users.entities;

import lombok.*;

import javax.persistence.*;

@ToString
@Entity
@Table(name = "books")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "book_id")
    private String bookId;

    @Column(name = "user_id")
    private String userId;
}
