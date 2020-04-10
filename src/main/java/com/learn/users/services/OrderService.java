package com.learn.users.services;

import com.learn.users.dto.mappers.OrderMapper;
import com.learn.users.dto.mappers.UserMapper;
import com.learn.users.dto.models.OrderDTO;
import com.learn.users.entities.Order;
import com.learn.users.entities.User;
import com.learn.users.exceptions.OrderNotFoundException;
import com.learn.users.exceptions.UserNotFoundException;
import com.learn.users.repositories.OrderRepository;
import com.learn.users.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {
    private OrderRepository orderRepository;
    private UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderMapper::toOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrdersByBookId(Long bookId) throws OrderNotFoundException {
        return orderRepository.getOrdersByBookId(bookId)
                .orElseThrow(() -> new OrderNotFoundException("Book id is not present"))
                .stream()
                .map(OrderMapper::toOrderDTO)
                .collect(Collectors.toList()
                );
    }

    @Override
    public OrderDTO createNewOrder(OrderDTO order) {
        Order newOrder = orderRepository.save(OrderMapper.toOrderEntity(order));
        return OrderMapper.toOrderDTO(newOrder);
    }
}
