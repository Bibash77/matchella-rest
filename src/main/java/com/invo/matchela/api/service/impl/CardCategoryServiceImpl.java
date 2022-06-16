package com.invo.matchela.api.service.impl;

import com.invo.matchela.api.entity.cards.CardCategory;
import com.invo.matchela.api.dao.CardCategoryRepository;
import com.invo.matchela.api.service.CardCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CardCategoryServiceImpl implements CardCategoryService {
    private final CardCategoryRepository repository;

    public CardCategoryServiceImpl(CardCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public CardCategory save(CardCategory entity) {
        return repository.save(entity);
    }

    @Override
    public List<CardCategory> saveAll(List<CardCategory> entities) {
        return (List<CardCategory>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<CardCategory> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<CardCategory> findAll() {
        return (List<CardCategory>) repository.findAll();
    }

    @Override
    public Page<CardCategory> findAll(Pageable pageable) {
        Page<CardCategory> entityPage = repository.findAll(pageable);
        List<CardCategory> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public CardCategory update(CardCategory entity, Long id) {
        Optional<CardCategory> optional = findById(id);
        if (optional.isPresent()) {
            entity.setId(id);
            return save(entity);
        }
        return null;
    }
}