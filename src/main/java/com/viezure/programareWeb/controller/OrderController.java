package com.viezure.programareWeb.controller;

import com.viezure.programareWeb.model.Order;
import com.viezure.programareWeb.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/registerOrder/{username}")
    public ResponseEntity <Order> registerOrder(@RequestBody Order order, @PathVariable String username){
        Order createdOrder = orderService.createOrder(order, username);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @PostMapping("/addItems/{id}")
    public ResponseEntity <Order> addItems(@RequestBody Map<Long, Long> items, @PathVariable Long id){

        Order updatedOrder = orderService.addItemsToOrder(items, id);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);

    }

    @GetMapping("/getAllByStatusCode/{code}")
    public ResponseEntity <List<Order>> getAllByStatusCode(@PathVariable String code){

        try{
            List<Order> orderList = orderService.getAllOrdersByStatusCode(code);
            return new ResponseEntity<>(orderList, HttpStatus.OK);
        }
        catch (Exception e){
            return null;
        }

    }

    @GetMapping("{id}/setStatus/{code}")
    public ResponseEntity <Order> setStatus (@PathVariable Long id, @PathVariable String code){
        Order order = orderService.setOrderStatus(id, code);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/getAllOrdersByUser/{username}")
    public ResponseEntity <List<Order>> getAllOrdersByUser (@PathVariable String username){
        List<Order> orderList = orderService.getAllOrdersByUser(username);
        if(!orderList.isEmpty())
            return new ResponseEntity<>(orderList, HttpStatus.FOUND);
        else
            return new ResponseEntity<>(orderList, HttpStatus.NOT_FOUND);
    }



}
