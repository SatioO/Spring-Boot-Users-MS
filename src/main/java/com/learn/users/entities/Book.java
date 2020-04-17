package com.learn.users.entities;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "books")
public class Book {

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

    @ManyToMany
    @JoinTable(
        name = "book_authors",
        joinColumns = { @JoinColumn(name = "book_id") },
        inverseJoinColumns = {@JoinColumn(name = "user_id")})
    @Fetch(FetchMode.SUBSELECT)
    private Set<User> authors;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name= "book_sections",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "section_id")
    )
    @Fetch(FetchMode.SUBSELECT)
    private Set<Section> sections;
}
