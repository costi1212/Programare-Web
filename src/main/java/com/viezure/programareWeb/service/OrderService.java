package com.viezure.programareWeb.service;

import com.viezure.programareWeb.exception.orderStatus.OrderStatusNotFoundException;
import com.viezure.programareWeb.exception.user.DuplicateEmailException;
import com.viezure.programareWeb.model.Order;
import com.viezure.programareWeb.model.OrderStatus;
import com.viezure.programareWeb.model.User;
import com.viezure.programareWeb.repository.OrderRepository;
import com.viezure.programareWeb.repository.OrderStatusRepository;
import com.viezure.programareWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @Autowired
    UserRepository userRepository;

    @Value("${order.status.duplicate.code}")
    String duplicateCodeMessage;

    @Value("${order.status.not.exists}")
    String notExistsMessage;


    public List<Order> getAllOrdersByStatusCode (String code){

        return orderRepository.getAllOrdersByStatusCode(code);

    }

    public Order setOrderStatus (Long orderId, String statusCode){
        Optional<OrderStatus> orderStatus = orderStatusRepository.findFirstByCode(statusCode);
        if(orderStatus.isPresent()){
            Order order = orderRepository.getById(orderId);
            order.setOrderStatus(orderStatus.get());
            orderRepository.save(order);
            return order;
        }
        else
            throw new OrderStatusNotFoundException(notExistsMessage, statusCode);
    }

    public List<Order> getAllOrdersByUser (String username){
        Optional <User> user = userRepository.getByUsername(username);
        List<Order> orderList = orderRepository.findAllByUser(user.get());
        return orderList;
    }

}
