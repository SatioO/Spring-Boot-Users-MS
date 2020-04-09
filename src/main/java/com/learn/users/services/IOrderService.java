package com.learn.users.services;
import com.learn.users.dto.models.OrderDTO;
import com.learn.users.exceptions.OrderNotFoundException;

import java.util.List;

public interface IOrderService {
    List<OrderDTO> getAllOrders();
    List<OrderDTO> getOrdersByBookId(Long bookId) throws OrderNotFoundException;
    OrderDTO createNewOrder(OrderDTO order);
}
