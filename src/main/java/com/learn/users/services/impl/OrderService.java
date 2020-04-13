package com.learn.users.services.impl;

import com.learn.users.dto.mappers.BookMapper;
import com.learn.users.dto.mappers.OrderMapper;
import com.learn.users.dto.mappers.UserMapper;
import com.learn.users.dto.models.OrderDTO;
import com.learn.users.entities.Book;
import com.learn.users.entities.Order;
import com.learn.users.entities.User;
import com.learn.users.exceptions.BookNotFoundException;
import com.learn.users.exceptions.UserNotFoundException;
import com.learn.users.repositories.BookRepository;
import com.learn.users.repositories.OrderRepository;
import com.learn.users.repositories.UserRepository;
import com.learn.users.services.IOrderService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Service
public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

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
    public OrderDTO createNewOrder(Long userId, Long bookId, OrderDTO order) throws UserNotFoundException, BookNotFoundException{
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found: " + userId));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book not found" + bookId));

        Order orderEntity = OrderMapper
                .toOrderEntity(order)
                .setBook(book)
                .setUser(user);

        return OrderMapper.toOrderDTO(orderRepository.save(orderEntity));
    }
}
