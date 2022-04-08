package com.bibash.invo.api.user.repository;

import java.util.Map;

import org.springframework.data.jpa.domain.Specification;

import com.bibash.invo.api.user.User;
import com.bibash.invo.core.BaseSpecBuilder;

public class UserSpecBuilder extends BaseSpecBuilder<User> {

    public UserSpecBuilder(Map<String, String> params) {
        super(params);
    }

    @Override
    protected Specification<User> getSpecification(String property, String filterValue) {
        return new UserSpec(property , filterValue);
    }
}
