package com.learn.users.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity @Getter @Setter
@Table(name="users")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 8634140154302985540L;

    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String gender;
    @Column(nullable = false, unique = true)
    private UUID userId;
}
