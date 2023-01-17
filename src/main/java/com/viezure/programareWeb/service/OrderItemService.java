package com.viezure.programareWeb.service;

import com.viezure.programareWeb.model.Item;
import com.viezure.programareWeb.model.Order;
import com.viezure.programareWeb.model.OrderItem;
import com.viezure.programareWeb.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderService orderService;

    public OrderItem addOrderItemToOrder(Item item, Long amount, Order order){
        OrderItem orderItem = this.findByOrderAndItem(item, order);
        if(orderItem == null) {
            OrderItem createdOrderItem = new OrderItem();
            createdOrderItem.setItem(item);
            createdOrderItem.setOrder(order);
            createdOrderItem.setQuantity(amount);
            createdOrderItem.setPrice(getOrderItemPrice(item, amount));
            orderItemRepository.save(createdOrderItem);
            return createdOrderItem;
        }
        else {
            orderItem.setQuantity(orderItem.getQuantity() + amount);
            return orderItem;
        }
    }

    public OrderItem findByOrderAndItem (Item item, Order order){

        Optional<OrderItem> orderItem = orderItemRepository.findByOrderAndItem(order, item);
        return orderItem.orElse(null);
    }

    public Float getOrderItemPrice(Item item, Long amount){

        return item.getPrice() * amount * item.getDiscount() /100;

    }

}
