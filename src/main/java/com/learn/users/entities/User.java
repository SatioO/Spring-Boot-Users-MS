package com.learn.users.entities;

import com.learn.users.enums.GenderType;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="users")
@Getter
@Setter
@Accessors(chain = true)
public class User implements Serializable {
    private static final long serialVersionUID = 8913185929168185170L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Enumerated(EnumType.ORDINAL)
    private GenderType genderType;

    @Column(nullable = false, length = 50)
    private String email;

    @OneToMany
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private List<Order> orders;
}
