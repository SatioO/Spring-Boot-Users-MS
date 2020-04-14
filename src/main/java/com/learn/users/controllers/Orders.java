package com.learn.users.controllers;

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

@AllArgsConstructor
@RestController
@RequestMapping(path = "orders")
public class Orders {
    private final IOrderService orderService;
    private final IUserService userService;
    private final IBookService bookService;

    @GetMapping
    public List<OrderDTO> getOrders() {
        return orderService.getAllOrders();
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
