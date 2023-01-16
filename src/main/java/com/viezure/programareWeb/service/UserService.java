package com.viezure.programareWeb.service;

import com.viezure.programareWeb.model.User;
import com.viezure.programareWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List <User> getAllUsers(){

        return userRepository.findAll();

    }

    public User createUser(User user){

        user.setRegistrationDate(new Date());
        userRepository.save(user);
        return user;

    }


}
