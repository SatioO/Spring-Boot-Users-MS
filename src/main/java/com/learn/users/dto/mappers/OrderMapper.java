package com.learn.users.dto.mappers;

import com.learn.users.dto.models.OrderDTO;
import com.learn.users.entities.Order;

public class OrderMapper {
    public static OrderDTO toOrderDTO(Order order) {
        return new OrderDTO()
                .id(order.id())
                .price(order.price())
                .couponCode(order.couponCode())
                .deliveredOn(order.deliveredOn())
                .orderedOn(order.orderedOn())
                .quantity(order.quantity());
    }

    public static Order toOrderEntity(OrderDTO order) {
        return new Order()
                .id(order.id())
                .price(order.price())
                .couponCode(order.couponCode())
                .deliveredOn(order.deliveredOn())
                .orderedOn(order.orderedOn())
                .quantity(order.quantity());
    }
}
