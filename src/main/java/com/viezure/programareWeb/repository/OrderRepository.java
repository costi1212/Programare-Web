package com.viezure.programareWeb.repository;

import com.viezure.programareWeb.model.Order;
import com.viezure.programareWeb.model.User;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long> {

    @Query(value = "SELECT o from Order o where o.orderStatus.id = :statusId")
    List <Order> getAllOrdersByStatusId (@Param("statusId") Long statusId);

    @Query(value = "SELECT o from Order o where o.orderStatus.code = :statusCode")
    List <Order> getAllOrdersByStatusCode (@Param("statusCode") String statusCode);

    List <Order> findAllByUser(User user);

}
