package com.viezure.programareWeb.controller;

import com.viezure.programareWeb.model.OrderStatus;
import com.viezure.programareWeb.repository.OrderRepository;
import com.viezure.programareWeb.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/orderStatus")
public class OrderStatusController {

    @Autowired
    OrderStatusService orderStatusService;

    @PostMapping("/create")
    public ResponseEntity <OrderStatus> createOrderStatus (@RequestBody @Valid OrderStatus orderStatus){

        OrderStatus createdUserStatus = orderStatusService.createOrderStatus(orderStatus);
        return new ResponseEntity<>(createdUserStatus, HttpStatus.CREATED);

    }



}
