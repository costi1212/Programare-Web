package com.viezure.programareWeb.exception.orderStatus;

public class DuplicateCodeException extends RuntimeException{

    public DuplicateCodeException (String code, String duplicateCodeMessage){
        super(duplicateCodeMessage + " " + code);
    }

}
