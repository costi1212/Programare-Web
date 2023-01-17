package com.viezure.programareWeb.service;

import com.viezure.programareWeb.model.Item;
import com.viezure.programareWeb.model.Order;
import com.viezure.programareWeb.model.OrderItem;
import com.viezure.programareWeb.repository.OrderItemRepository;
import com.viezure.programareWeb.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderRepository orderRepository;

    public void addOrderItemToOrder(Item item, Long amount, Order order){
        OrderItem orderItem = this.findByOrderAndItem(item, order);
        if(orderItem == null) {
            OrderItem createdOrderItem = new OrderItem();
            createdOrderItem.setItem(item);
            createdOrderItem.setOrder(order);
            createdOrderItem.setQuantity(amount);
            createdOrderItem.setPrice(getOrderItemPrice(item, amount));
            order.setSubTotal(order.getSubTotal() == null ? createdOrderItem.getPrice() : order.getSubTotal() + createdOrderItem.getPrice());
            if(order.getDiscount() != null)
                order.setGrandTotal(order.getSubTotal() * order.getDiscount() / 100 );
            else
                order.setGrandTotal(order.getSubTotal());
            orderRepository.save(order);
            orderItemRepository.save(createdOrderItem);
        }
        else {
            orderItem.setQuantity(orderItem.getQuantity() + amount);
            order.setSubTotal(order.getSubTotal() == null ? orderItem.getPrice() : order.getSubTotal() + orderItem.getPrice());
            if(order.getDiscount() != null)
                order.setGrandTotal(order.getSubTotal() * order.getDiscount() / 100 );
            else
                order.setGrandTotal(order.getSubTotal());
            orderRepository.save(order);
            orderItemRepository.save(orderItem);
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
