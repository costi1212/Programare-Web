package com.viezure.programareWeb.service;

import com.viezure.programareWeb.model.Order;
import com.viezure.programareWeb.model.OrderStatus;
import com.viezure.programareWeb.model.User;
import com.viezure.programareWeb.repository.OrderRepository;
import com.viezure.programareWeb.repository.OrderStatusRepository;
import com.viezure.programareWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @Autowired
    UserRepository userRepository;

    public List<Order> getAllOrdersByStatusCode (String code){

        return orderRepository.getAllOrdersByStatusCode(code);

    }

    public Order setOrderStatus (Long orderId, String statusCode){
        OrderStatus orderStatus = orderStatusRepository.findFirstByCode(statusCode);
        Order order = orderRepository.getById(orderId);
        order.setOrderStatus(orderStatus);
        orderRepository.save(order);
        return order;
    }

    public List<Order> getAllOrdersByUser (String username){
        User user = userRepository.getByUsername(username);
        List<Order> orderList = orderRepository.findAllByUser(user);
        return orderList;
    }

}
