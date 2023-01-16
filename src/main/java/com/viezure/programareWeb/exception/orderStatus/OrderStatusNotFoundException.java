package com.viezure.programareWeb.exception.orderStatus;

public class OrderStatusNotFoundException extends RuntimeException{

    public OrderStatusNotFoundException(String message, String code){
        super(message + " " + code);
    }

}
