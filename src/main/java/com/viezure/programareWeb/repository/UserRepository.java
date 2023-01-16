package com.viezure.programareWeb.repository;

import com.viezure.programareWeb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional <User> getByUsername (String username);

    User getAllByLastLoginBetween(Date firstDate, Date secondDate);

    Optional <User> getByEmail (String email);

}
