package com.viezure.programareWeb.service;

import com.viezure.programareWeb.exception.orderStatus.DuplicateCodeException;
import com.viezure.programareWeb.exception.orderStatus.OrderStatusNotFoundException;
import com.viezure.programareWeb.model.OrderStatus;
import com.viezure.programareWeb.repository.OrderRepository;
import com.viezure.programareWeb.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderStatusService {

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @Value("${order.status.not.exists}")
    String orderStatusNotFoundMessage;

    @Value("${order.status.duplicate.code}")
    String orderStatusDuplicateCode;


    public OrderStatus createOrderStatus(OrderStatus orderStatus){
        Optional<OrderStatus> existingOrderStatus = orderStatusRepository.findFirstByCode(orderStatus.getCode());
        if(existingOrderStatus.isPresent()){
            throw new DuplicateCodeException(existingOrderStatus.get().getCode(), orderStatusDuplicateCode);
        }
        else {
            orderStatusRepository.save(orderStatus);
            return orderStatus;
        }
    }


}
