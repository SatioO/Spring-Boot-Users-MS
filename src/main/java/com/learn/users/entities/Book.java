package com.learn.users.entities;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@Accessors(chain = true)
public class Book implements Serializable {
    private static final long serialVersionUID = 9188451047948590951L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @JoinColumn(name = "book_id")
    private List<Order> orders;
}
