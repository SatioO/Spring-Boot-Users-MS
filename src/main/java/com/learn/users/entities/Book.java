package com.learn.users.entities;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true, fluent = true)
@Entity
@Table(name = "books")
public class Book implements Serializable {
    private static final long serialVersionUID = 9188451047948590951L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    Long id;

    @Column(nullable = false)
    String name;

    @Column
    String description;

    @Column(nullable = false)
    int price;

    @Temporal(TemporalType.DATE)
    Date publishedOn;
}
