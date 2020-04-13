package com.learn.users.entities;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "books")
public class Book implements Serializable {
    private static final long serialVersionUID = 9188451047948590951L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private int price;

    @Temporal(TemporalType.DATE)
    private Date publishedOn;

    @OneToMany
    @JoinColumn(name = "bookId")
    private List<Order> orders;
}
