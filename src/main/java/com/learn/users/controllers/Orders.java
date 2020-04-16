package com.learn.users.controllers;

import com.learn.users.dto.models.BookDTO;
import com.learn.users.dto.models.OrderDTO;
import com.learn.users.dto.models.UserDTO;
import com.learn.users.repositories.OrderRepository;
import com.learn.users.services.IBookService;
import com.learn.users.services.IOrderService;
import com.learn.users.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        List<Object> result = Stream.of(userService.getUserById(userId), bookService.getBookById(bookId)).parallel().collect(Collectors.toList());
        UserDTO user = (UserDTO)result.get(0);
        BookDTO book = (BookDTO) result.get(1);
        return orderService.createNewOrder(user, book, order);
    }
}
