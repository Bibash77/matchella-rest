package com.invo.matchela.api.user.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.invo.matchela.api.user.User;
import com.invo.matchela.core.enums.Status;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUserName(String userName);


    Long countByStatus(Status status);

    @Query("select COUNT(u) as user from User u where u.status= :status")
    Map<String , Long> countUsers(Status status);
}