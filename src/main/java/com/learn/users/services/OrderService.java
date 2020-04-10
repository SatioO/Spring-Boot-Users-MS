package com.learn.users.services;

import com.learn.users.dto.mappers.OrderMapper;
import com.learn.users.dto.models.OrderDTO;
import com.learn.users.entities.Order;
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
