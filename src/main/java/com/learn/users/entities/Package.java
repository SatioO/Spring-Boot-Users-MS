package com.learn.users.entities;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "packages")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Long id;

    @Column
    private String name;
}
