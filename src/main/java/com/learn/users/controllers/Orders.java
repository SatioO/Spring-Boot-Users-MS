package com.learn.users.controllers;

import com.learn.users.dto.models.OrderDTO;
import com.learn.users.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "orders")
public class Orders {
    @Autowired
    private IOrderService orderService;

    @GetMapping
    public List<OrderDTO> getOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public OrderDTO createOrder(@RequestBody @Valid OrderDTO order) {
        return orderService.createNewOrder(order);
    }
}
