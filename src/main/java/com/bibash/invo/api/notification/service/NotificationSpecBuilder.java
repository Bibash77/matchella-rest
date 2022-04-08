package com.bibash.invo.api.notification.service;

import java.util.Map;

import org.springframework.data.jpa.domain.Specification;

import com.bibash.invo.api.notification.Message;
import com.bibash.invo.core.BaseSpecBuilder;

public class NotificationSpecBuilder extends BaseSpecBuilder<Message> {

    public NotificationSpecBuilder(Map<String, String> params) {
        super(params);
    }

    @Override
    protected Specification<Message> getSpecification(String property, String filterValue) {
        return new NotificationSpec(property , filterValue);
    }
}
