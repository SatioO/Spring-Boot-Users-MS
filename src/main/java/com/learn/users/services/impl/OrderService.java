package com.learn.users.services.impl;

import com.learn.users.dto.mappers.BookMapper;
import com.learn.users.dto.mappers.OrderMapper;
import com.learn.users.dto.mappers.UserMapper;
import com.learn.users.dto.models.BookDTO;
import com.learn.users.dto.models.OrderDTO;
import com.learn.users.dto.models.UserDTO;
import com.learn.users.entities.Order;
import com.learn.users.exceptions.BookNotFoundException;
import com.learn.users.repositories.OrderRepository;
import com.learn.users.services.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(order -> OrderMapper.toOrderDTO(order)
                        /** CHECK LAZY BEHAVIOR OF MAPPING **/
//                        .setUser(UserMapper.toUserDTO(order.getUser()))
//                        .setBook(BookMapper.toBookDTO(order.getBook()))
                )
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrdersByBookId(Long bookId) throws BookNotFoundException {
        return orderRepository.findOrdersByBookId(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book not found: " + bookId))
                .stream()
                .map(OrderMapper::toOrderDTO)
                .collect(Collectors.toList()
                );
    }

    @Override
    public OrderDTO createNewOrder(UserDTO user, BookDTO book, OrderDTO order) {
        Order orderEntity = OrderMapper
                .toOrderEntity(order)
                .setUser(UserMapper.toUserEntity(user))
                .setBook(BookMapper.toBookEntity(book));

        return OrderMapper.toOrderDTO(orderRepository.save(orderEntity));
    }
}
