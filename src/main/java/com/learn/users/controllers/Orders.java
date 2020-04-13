package com.learn.users.controllers;

import com.learn.users.dto.models.OrderDTO;
import com.learn.users.services.IOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "orders")
public class Orders {
    private IOrderService orderService;

    public Orders(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDTO> findAll() {
        return orderService.getAllOrders();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public OrderDTO save(@RequestBody @Valid OrderDTO order) {
        return orderService.createNewOrder(order);
    }

}
