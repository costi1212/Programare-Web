package com.viezure.programareWeb.exception;

import org.springframework.beans.factory.annotation.Value;

public class DuplicateEmailException extends RuntimeException {

    public DuplicateEmailException(String email, @Value("${user.exception.duplicate.email}") String duplicateEmailMessage) {
        super(duplicateEmailMessage + email);
    }

}
