package com.learn.users.entities;
import com.learn.users.enums.RoleType;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
@Accessors(chain = true)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private RoleType role;
}
