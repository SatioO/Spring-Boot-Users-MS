package com.learn.users.services;

import com.learn.users.dto.mappers.OrderMapper;
import com.learn.users.dto.mappers.UserMapper;
import com.learn.users.dto.models.OrderDTO;
import com.learn.users.dto.models.UserDTO;
import com.learn.users.entities.User;
import com.learn.users.exceptions.OrderNotFoundException;
import com.learn.users.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(order -> OrderMapper
                        .toOrderDTO(order)
                        .setUser(UserMapper.toUserDTO(order.getUser()))
                )
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
        return OrderMapper.toOrderDTO(orderRepository.save(
                OrderMapper.toOrderEntity(order)
                        .setUser(
                                new User().setId(order.getUserId())
                        )
                )
        );
    }
}
