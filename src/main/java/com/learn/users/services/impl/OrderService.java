package com.learn.users.services.impl;

import com.learn.users.dto.mappers.OrderMapper;
import com.learn.users.dto.mappers.UserMapper;
import com.learn.users.dto.models.OrderDTO;
import com.learn.users.exceptions.UserNotFoundException;
import com.learn.users.repositories.OrderRepository;
import com.learn.users.repositories.UserRepository;
import com.learn.users.services.IOrderService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(order -> OrderMapper.toOrderDTO(order)
                        .setUser(UserMapper.toUserDTO(order.getUser()))
                )
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO createNewOrder(Long userId, OrderDTO order) {
        return userRepository.findById(userId).map(user ->
            OrderMapper.toOrderDTO(
                    orderRepository.save(
                            user.add(OrderMapper.toOrderEntity(order))
                    )
            )
        ).orElseThrow(() -> new UserNotFoundException("user not found: " + userId));
    }
}
