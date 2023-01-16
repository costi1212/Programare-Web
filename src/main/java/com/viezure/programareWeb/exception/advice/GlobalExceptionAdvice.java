package com.viezure.programareWeb.exception.advice;

import com.viezure.programareWeb.exception.orderStatus.DuplicateCodeException;
import com.viezure.programareWeb.exception.user.DuplicateEmailException;
import com.viezure.programareWeb.exception.user.DuplicateUsernameException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler({DuplicateEmailException.class})
    public ResponseEntity handle(DuplicateEmailException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler({DuplicateUsernameException.class})
    public ResponseEntity handle(DuplicateUsernameException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler({DuplicateCodeException.class})
    public ResponseEntity handle(DuplicateCodeException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
