package com.learn.users.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy="department", cascade={CascadeType.PERSIST})
    @Fetch(value=FetchMode.SUBSELECT)
    private List<Employee> employees = new ArrayList<>();
}
