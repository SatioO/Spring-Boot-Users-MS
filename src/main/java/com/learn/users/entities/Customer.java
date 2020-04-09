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

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String gender;
}
