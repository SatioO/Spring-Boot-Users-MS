package com.learn.users.services;
import com.learn.users.dto.models.OrderDTO;
import java.util.List;

public interface IOrderService {
    List<OrderDTO> getAllOrders();
    OrderDTO createNewOrder(OrderDTO order);
}
