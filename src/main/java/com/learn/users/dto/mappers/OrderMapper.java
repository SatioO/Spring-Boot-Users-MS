package com.learn.users.dto.mappers;

import com.learn.users.dto.models.OrderDTO;
import com.learn.users.entities.Order;
import com.learn.users.entities.User;

public class OrderMapper {
    public static OrderDTO toOrderDTO(Order order) {
        return new OrderDTO()
                .setId(order.getId())
                .setPrice(order.getPrice())
                .setBookId(order.getBookId())
                .setCouponCode(order.getCouponCode())
                .setDeliveredOn(order.getDeliveredOn())
                .setOrderedOn(order.getOrderedOn())
                .setQuantity(order.getQuantity());
    }

    public static Order toOrderEntity(OrderDTO order) {
        return new Order()
                .setId(order.getId())
                .setPrice(order.getPrice())
                .setBookId(order.getBookId())
                .setCouponCode(order.getCouponCode())
                .setDeliveredOn(order.getDeliveredOn())
                .setOrderedOn(order.getOrderedOn())
                .setUser(new User().setId(order.getUserId()));
    }
}
