package com.invo.matchela.api.service;

import com.invo.matchela.api.entity.cards.UserFavCategory;

import java.util.List;

public interface UserFavCategoryService extends GenericService<UserFavCategory, Long> {
    void addMultipleCategory(List<Long> ids);
}