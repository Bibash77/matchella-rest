package com.invo.matchela.api.dao;

import com.invo.matchela.api.entity.cards.Card;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends PagingAndSortingRepository<Card, Long> {
}