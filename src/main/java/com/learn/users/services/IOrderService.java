package com.learn.users.services;
import com.learn.users.dto.models.OrderDTO;
import java.util.List;

public interface IOrderService {
    List<OrderDTO> getAllOrders();
    List<OrderDTO> getOrdersByBookId(Long bookId);
    OrderDTO createNewOrder(OrderDTO order);
}
