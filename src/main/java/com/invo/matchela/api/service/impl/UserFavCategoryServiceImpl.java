package com.invo.matchela.api.service.impl;

import com.invo.matchela.api.entity.cards.UserFavCategory;
import com.invo.matchela.api.dao.UserFavCategoryRepository;
import com.invo.matchela.api.service.UserFavCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserFavCategoryServiceImpl implements UserFavCategoryService {
    private final UserFavCategoryRepository repository;

    public UserFavCategoryServiceImpl(UserFavCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserFavCategory save(UserFavCategory entity) {
        return repository.save(entity);
    }

    @Override
    public List<UserFavCategory> save(List<UserFavCategory> entities) {
        return (List<UserFavCategory>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<UserFavCategory> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<UserFavCategory> findAll() {
        return (List<UserFavCategory>) repository.findAll();
    }

    @Override
    public Page<UserFavCategory> findAll(Pageable pageable) {
        Page<UserFavCategory> entityPage = repository.findAll(pageable);
        List<UserFavCategory> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public UserFavCategory update(UserFavCategory entity, Long id) {
        Optional<UserFavCategory> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}