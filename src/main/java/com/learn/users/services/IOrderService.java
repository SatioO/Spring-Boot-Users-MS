package com.learn.users.services;
import com.learn.users.dto.models.BookDTO;
import com.learn.users.dto.models.OrderDTO;
import com.learn.users.dto.models.UserDTO;
import com.learn.users.exceptions.UserNotFoundException;

import java.util.List;

public interface IOrderService {
    List<OrderDTO> getAllOrders();

    OrderDTO createNewOrder(UserDTO user, BookDTO book, OrderDTO order) throws UserNotFoundException;
}
