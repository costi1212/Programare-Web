package com.viezure.programareWeb.repository;

import com.viezure.programareWeb.model.Item;
import com.viezure.programareWeb.model.Order;
import com.viezure.programareWeb.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    Optional<OrderItem> findByOrderAndItem (Order order, Item item);

}
