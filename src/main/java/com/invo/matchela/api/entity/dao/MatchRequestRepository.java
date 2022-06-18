package com.invo.matchela.api.entity.dao;

import com.invo.matchela.api.entity.cards.MatchRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRequestRepository extends PagingAndSortingRepository<MatchRequest, Long> {
}