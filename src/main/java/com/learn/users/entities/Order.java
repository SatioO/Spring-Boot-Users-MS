package com.learn.users.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders")
@Getter
@Setter
@Accessors(chain = true)
public class Order implements Serializable {
    private static final long serialVersionUID = -7826265172441981769L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int price;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "book_id", nullable = false)
    private Long bookId;
}
