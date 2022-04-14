package com.invo.matchela.api.user.repository;

import java.util.Map;

import com.invo.matchela.api.user.User;
import org.springframework.data.jpa.domain.Specification;

import com.invo.matchela.core.BaseSpecBuilder;

public class UserSpecBuilder extends BaseSpecBuilder<User> {

    public UserSpecBuilder(Map<String, String> params) {
        super(params);
    }

    @Override
    protected Specification<User> getSpecification(String property, String filterValue) {
        return new UserSpec(property , filterValue);
    }
}
