package com.viezure.programareWeb.exception.order;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(String message, Long id){
        super(message + " " + id);
    }

}
