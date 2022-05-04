package com.invo.matchela.api.service;

import java.util.Map;

import com.invo.matchela.api.entity.Notification;
import com.invo.matchela.core.BaseSpecBuilder;
import org.springframework.data.jpa.domain.Specification;

public class NotificationSpecBuilder extends BaseSpecBuilder<Notification> {

    public NotificationSpecBuilder(Map<String, String> params) {
        super(params);
    }

    @Override
    protected Specification<Notification> getSpecification(String property, String filterValue) {
        return new NotificationSpec(property , filterValue);
    }
}
