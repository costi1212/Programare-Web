package com.viezure.programareWeb.exception.user;

import org.springframework.beans.factory.annotation.Value;

public class DuplicateEmailException extends RuntimeException {

    public DuplicateEmailException( String duplicateEmailMessage, String email) {
        super(duplicateEmailMessage + " " + email);
    }



}
