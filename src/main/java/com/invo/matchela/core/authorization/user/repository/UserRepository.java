package com.invo.matchela.core.authorization.user.repository;

import com.invo.matchela.core.authorization.user.User;
import com.invo.matchela.core.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String userName);

    User getUsersByUsername(String username);

    Long countByStatus(Status status);

    User findUserById(Long id);

    @Query("select COUNT(u) as user from User u where u.status= :status")
    Map<String, Long> countUsers(Status status);
}
