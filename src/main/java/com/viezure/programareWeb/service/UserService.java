package com.viezure.programareWeb.service;

import com.viezure.programareWeb.exception.user.DuplicateEmailException;
import com.viezure.programareWeb.model.User;
import com.viezure.programareWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Value("${user.exception.duplicate.email}")
    String duplicateEmailMessage;

    @Value("${user.exception.duplicate.username}")
    String duplicateEmailUsername;

    public List <User> getAllUsers(){

        return userRepository.findAll();

    }

    public User createUser(User user){
        Optional <User> existingUserEmail = userRepository.getByEmail(user.getEmail());
        existingUserEmail.ifPresent(e -> {
            throw  new DuplicateEmailException(duplicateEmailMessage , e.getEmail());
        });
        Optional <User> existingUserUsername = userRepository.getByUsername(user.getUsername());
        existingUserUsername.ifPresent(e ->{
            throw  new DuplicateEmailException(duplicateEmailUsername , e.getUsername());
        });
        user.setRegistrationDate(new Date());
        userRepository.save(user);
        return user;
    }


}
