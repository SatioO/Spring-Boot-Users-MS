package com.learn.users.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    private static final long serialVersionUID = -7826265172441981769L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
