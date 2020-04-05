package com.learn.users.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
@Getter @Setter
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 8634140154302985540L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String gender;
    @Column(nullable = false, unique = true)
    private String userId;
}
