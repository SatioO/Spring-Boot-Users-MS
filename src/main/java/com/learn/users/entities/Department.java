package com.learn.users.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @OneToMany(mappedBy="department",cascade=CascadeType.PERSIST)
    @Fetch(value=FetchMode.SELECT)
    @BatchSize(size = 3)
    private List<Employee> employees = new ArrayList<>();
}
