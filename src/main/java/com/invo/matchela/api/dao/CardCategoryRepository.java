package com.invo.matchela.api.dao;

import com.invo.matchela.api.entity.cards.CardCategory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardCategoryRepository extends PagingAndSortingRepository<CardCategory, Long> {
}