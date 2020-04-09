package com.learn.users.dto.mappers;

import com.learn.users.dto.models.OrderDTO;
import com.learn.users.entities.Order;

public class OrderMapper {
    public static OrderDTO toOrderDTO(Order order) {
        return new OrderDTO().setPrice(order.getPrice());
    }

    public static Order toOrderEntity(OrderDTO order) {
        return new Order().setPrice(order.getPrice());
    }
}
