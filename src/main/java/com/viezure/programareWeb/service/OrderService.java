package com.viezure.programareWeb.service;

import com.viezure.programareWeb.exception.order.OrderNotFoundException;
import com.viezure.programareWeb.exception.orderStatus.OrderStatusNotFoundException;
import com.viezure.programareWeb.model.Item;
import com.viezure.programareWeb.model.Order;
import com.viezure.programareWeb.model.OrderStatus;
import com.viezure.programareWeb.model.User;
import com.viezure.programareWeb.repository.ItemRepository;
import com.viezure.programareWeb.repository.OrderRepository;
import com.viezure.programareWeb.repository.OrderStatusRepository;
import com.viezure.programareWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    OrderStatusService orderStatusService;

    @Autowired
    UserService userService;

    @Value("${order.status.duplicate.code}")
    String duplicateCodeMessage;

    @Value("${order.status.not.exists}")
    String notExistsMessage;

    @Value("${order.not.exists}")
    String orderNotExistsMessage;

    public Order createOrder (Order order, String username){

        order.setOrderStatus(orderStatusRepository.findFirstByCode("REGISTERED").get());
        order.setUser(userService.getByUsername(username));
        return orderRepository.save(order);

    }

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

    public Order addItemsToOrder (Map<Long, Long> itemMap, Long id){
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()){
            itemMap.forEach((itemId, amount) ->{
                Item item = itemRepository.getReferenceById(itemId);
                orderItemService.addOrderItemToOrder(item, amount, order.get());
            });
            return order.get();
        }
        else
            throw new OrderNotFoundException(notExistsMessage, id);
    }

    public List<Order> getAllOrdersByUser (String username){
        Optional <User> user = userRepository.getByUsername(username);
        List<Order> orderList = orderRepository.findAllByUser(user.get());
        return orderList;
    }


}
