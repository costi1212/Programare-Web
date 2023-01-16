package com.viezure.programareWeb.exception.orderStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class DuplicateCodeException extends RuntimeException{

    DuplicateCodeException (String code, String duplicateCodeMessage){
        super(duplicateCodeMessage + " " + code);
    }

}
