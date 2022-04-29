package com.invo.matchela.api.entity.service.impl;

import com.invo.matchela.api.entity.cards.Card;
import com.invo.matchela.api.entity.dao.CardRepository;
import com.invo.matchela.api.entity.dto.CardDTO;
import com.invo.matchela.api.entity.mapper.CardMapper;
import com.invo.matchela.api.entity.service.CardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CardServiceImpl implements CardService {
    private final CardRepository repository;

    public CardServiceImpl(CardRepository repository) {
        this.repository = repository;
    }

    @Override
    public Card save(Card entity) {
        return repository.save(entity);
    }

    @Override
    public List<Card> save(List<Card> entities) {
        return (List<Card>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Card> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Card> findAll() {
        return (List<Card>) repository.findAll();
    }

    @Override
    public Page<Card> findAll(Pageable pageable) {
        Page<Card> entityPage = repository.findAll(pageable);
        List<Card> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Card update(Card entity, Long id) {
        Optional<Card> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}