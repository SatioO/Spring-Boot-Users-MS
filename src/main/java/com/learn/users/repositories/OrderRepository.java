package com.learn.users.repositories;

import com.learn.users.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<List<Order>> getOrdersByBookId(Long bookId);
}