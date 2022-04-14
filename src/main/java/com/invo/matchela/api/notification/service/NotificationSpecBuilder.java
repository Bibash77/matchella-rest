package com.invo.matchela.api.notification.service;

import java.util.Map;

import com.invo.matchela.api.notification.Message;
import com.invo.matchela.core.BaseSpecBuilder;
import org.springframework.data.jpa.domain.Specification;

public class NotificationSpecBuilder extends BaseSpecBuilder<Message> {

    public NotificationSpecBuilder(Map<String, String> params) {
        super(params);
    }

    @Override
    protected Specification<Message> getSpecification(String property, String filterValue) {
        return new NotificationSpec(property , filterValue);
    }
}
