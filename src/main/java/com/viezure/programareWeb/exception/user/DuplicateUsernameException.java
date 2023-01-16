package com.viezure.programareWeb.exception.user;

import org.springframework.beans.factory.annotation.Value;

public class DuplicateUsernameException extends RuntimeException {

    public DuplicateUsernameException(String username, @Value("${user.exception.duplicate.username}") String duplicateUsernameMessage){
        super(duplicateUsernameMessage + " " + username);
    }

}
