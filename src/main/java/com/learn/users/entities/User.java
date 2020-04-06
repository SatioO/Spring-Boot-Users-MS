package com.learn.users.entities;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Entity
@Table(name="users")
@Accessors(chain = true)
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class User extends Audit<String> implements Serializable {
    private static final long serialVersionUID = -272304721125200303L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String gender;
    @Column(nullable = false, updatable = false, unique = true)
    private String userId;

    @PrePersist
    public void persist() {
        System.out.println("Persisting ...");
    }
}
