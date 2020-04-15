package com.learn.users.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false)
    private int quantity;

    @Column(length = 10)
    private String couponCode;

    @Temporal(TemporalType.DATE)
    private Date orderedOn;

    @Temporal(TemporalType.DATE)
    private Date deliveredOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bookId", nullable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    
}
