package com.learn.users.entities;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@ToString
@Entity
@Table(name = "books")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Accessors(chain = true)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "book_id", nullable = false, updatable = false, unique = true)
    private String bookId;

    @OneToMany
    private List<Customer> authors;
}
