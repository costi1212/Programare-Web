package com.viezure.programareWeb.service;

import com.viezure.programareWeb.model.OrderStatus;
import com.viezure.programareWeb.repository.OrderRepository;
import com.viezure.programareWeb.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusService {

    @Autowired
    OrderStatusRepository orderStatusRepository;

    public OrderStatus createOrderStatus(OrderStatus orderStatus){

        orderStatusRepository.save(orderStatus);
        return orderStatus;

    }

}
