package com.learn.users.dto.mappers;

import com.learn.users.dto.models.OrderDTO;
import com.learn.users.entities.Order;

public class OrderMapper {
    public static OrderDTO toOrderDTO(Order order) {
        return new OrderDTO()
                .setId(order.getId())
                .setPrice(order.getTotalPrice())
                .setCouponCode(order.getCouponCode())
                .setDeliveredOn(order.getDeliveredOn())
                .setOrderedOn(order.getOrderedOn())
                .setQuantity(order.getQuantity());
    }

    public static Order toOrderEntity(OrderDTO order) {
        return new Order()
                .setId(order.getId())
                .setTotalPrice(order.getPrice())
                .setCouponCode(order.getCouponCode())
                .setDeliveredOn(order.getDeliveredOn())
                .setOrderedOn(order.getOrderedOn())
                .setQuantity(order.getQuantity());
    }
}
