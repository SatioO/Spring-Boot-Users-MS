package com.learn.users.controllers;

import com.learn.users.repositories.OrderRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.learn.users.dto.models.BookDTO;
import com.learn.users.dto.models.OrderDTO;
import com.learn.users.dto.models.UserDTO;
import com.learn.users.services.IBookService;
import com.learn.users.services.IOrderService;
import com.learn.users.services.IUserService;

import lombok.AllArgsConstructor;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping(path = "orders")
@AllArgsConstructor
public class Orders {
    private final IOrderService orderService;
    private final IUserService userService;
    private final IBookService bookService;
    private final OrderRepository orderRepository;

    @GetMapping
    public List<OrderDTO> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/book/{bookId}")
    public List<OrderDTO> getOrderByBookId(@PathVariable Long bookId) {
        return orderService.getOrdersByBookId(bookId);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public OrderDTO createOrder(
            @RequestParam("userId") Long userId,
            @RequestParam("bookId") Long bookId,
            @RequestBody @Valid OrderDTO order) {

        UserDTO user = userService.getUserById(userId);
        BookDTO book = bookService.getBookById(bookId);

        return orderService.createNewOrder(user, book, order);
    }

}
