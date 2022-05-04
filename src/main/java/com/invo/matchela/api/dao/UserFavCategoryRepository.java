package com.invo.matchela.api.dao;

import com.invo.matchela.api.entity.cards.UserFavCategory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFavCategoryRepository extends PagingAndSortingRepository<UserFavCategory, Long> {
}