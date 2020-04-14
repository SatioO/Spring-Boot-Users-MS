package com.learn.users.services;
import com.learn.users.dto.models.BookDTO;
import com.learn.users.dto.models.OrderDTO;
import com.learn.users.dto.models.UserDTO;
import com.learn.users.exceptions.UserNotFoundException;

import java.util.List;

public interface IOrderService {
    List<OrderDTO> getAllOrders();

    List<OrderDTO> getOrdersByBookId(Long bookId);

    OrderDTO createNewOrder(UserDTO user, BookDTO book, OrderDTO order) throws UserNotFoundException;
}
