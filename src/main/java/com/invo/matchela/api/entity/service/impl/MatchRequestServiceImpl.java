package com.invo.matchela.api.entity.service.impl;

import com.invo.matchela.api.entity.cards.MatchRequest;
import com.invo.matchela.api.entity.dao.MatchRequestRepository;
import com.invo.matchela.api.entity.dto.MatchRequestDTO;
import com.invo.matchela.api.entity.mapper.MatchRequestMapper;
import com.invo.matchela.api.entity.service.MatchRequestService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MatchRequestServiceImpl implements MatchRequestService {
    private final MatchRequestRepository repository;

    public MatchRequestServiceImpl(MatchRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public MatchRequest save(MatchRequest entity) {
        return repository.save(entity);
    }

    @Override
    public List<MatchRequest> saveAll(List<MatchRequest> entities) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<MatchRequest> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<MatchRequest> findAll() {
        return (List<MatchRequest>) repository.findAll();
    }

    @Override
    public Page<MatchRequest> findAll(Pageable pageable) {
        Page<MatchRequest> entityPage = repository.findAll(pageable);
        List<MatchRequest> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public MatchRequest update(MatchRequest entity, Long id) {
        Optional<MatchRequest> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}