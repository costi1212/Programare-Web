package com.viezure.programareWeb.repository;

import com.viezure.programareWeb.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends JpaRepository <OrderStatus, Long> {

    OrderStatus findFirstByCode (String code);

}
