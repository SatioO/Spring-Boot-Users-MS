package com.learn.users.entities;

import com.learn.users.dto.models.UserDTO;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, updatable = false, unique = true)
    private String bookId;
}
