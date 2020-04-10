package com.learn.users.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

    @Column(nullable = false)
    private int quantity;

    @Column(length = 10)
    private String couponCode;

    @Temporal(TemporalType.DATE)
    private Date orderedOn;

    @Temporal(TemporalType.DATE)
    private Date deliveredOn;

    @Column(nullable = false)
    private Long bookId;

    @ManyToOne
    private User user;
}
