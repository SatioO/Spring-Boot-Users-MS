package com.learn.users.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ToString
@Entity
@Table(name="users")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class User extends Audit<String> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String gender;

    @Column(name="user_id")
    private String userId;

    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<Book> books;
}
