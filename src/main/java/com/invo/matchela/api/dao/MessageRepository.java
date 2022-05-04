package com.invo.matchela.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.invo.matchela.api.entity.Notification;

@Repository
public interface MessageRepository extends JpaRepository<Notification, Long>,
    JpaSpecificationExecutor<Notification> {

}
