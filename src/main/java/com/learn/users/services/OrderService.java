package com.learn.users.services;

import com.learn.users.dto.mappers.OrderMapper;
import com.learn.users.dto.mappers.UserMapper;
import com.learn.users.dto.models.OrderDTO;
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
                .map(order -> OrderMapper.toOrderDTO(order)
                        .setUser(UserMapper.toUserDTO(order.getUser()))
                )
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO createNewOrder(OrderDTO order) {
        return userRepository.findById(order.getUserId()).map(user ->
            OrderMapper.toOrderDTO(
                    orderRepository.save(
                            user.add(OrderMapper.toOrderEntity(order))
                    )
            )
        ).orElseThrow(() -> new UserNotFoundException("user not found: " + order.getUserId()));
    }
}
