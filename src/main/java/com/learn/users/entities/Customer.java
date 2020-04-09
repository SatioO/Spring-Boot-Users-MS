package com.learn.users.entities;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Entity
@Table(name="customers")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Accessors(chain = true)
public class Customer extends Audit<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 10)
    private String gender;

    @Column(nullable = false, length = 50)
    private String email;
}
