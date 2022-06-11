package com.invo.matchela.api.service.impl;

import com.invo.matchela.api.entity.cards.UserFavCategory;
import com.invo.matchela.api.dao.UserFavCategoryRepository;
import com.invo.matchela.api.service.UserFavCategoryService;
import com.invo.matchela.core.authorization.user.AuthenticationUtils;
import com.invo.matchela.core.authorization.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserFavCategoryServiceImpl implements UserFavCategoryService {
    private final UserFavCategoryRepository repository;
    private final AuthenticationUtils authenticationUtils;

    public UserFavCategoryServiceImpl(UserFavCategoryRepository repository, AuthenticationUtils authenticationUtils) {
        this.repository = repository;
        this.authenticationUtils = authenticationUtils;
    }

    @Override
    public UserFavCategory save(UserFavCategory entity) {
        return repository.save(entity);
    }

    @Override
    public List<UserFavCategory> saveAll(List<UserFavCategory> entities) {
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

    @Override
    public void addMultipleCategory(List<Long> ids) {
        List<UserFavCategory> userFavCategories = new ArrayList<>();

        User user = authenticationUtils.getUser();
        ids.forEach(id -> {
            UserFavCategory uf = new UserFavCategory();
            uf.setCardCategoryId(id);
            uf.setUser(user);
            userFavCategories.add(uf);
        });
        this.saveAll(userFavCategories);
    }
}