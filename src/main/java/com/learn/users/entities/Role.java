package com.learn.users.entities;
import com.learn.users.enums.RoleType;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Accessors(chain = true, fluent = true)
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private RoleType role;
}
