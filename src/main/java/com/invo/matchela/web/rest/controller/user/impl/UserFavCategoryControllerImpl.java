package com.invo.matchela.web.rest.controller.user.impl;

import com.invo.matchela.api.entity.cards.UserFavCategory;
import com.invo.matchela.core.dto.MatchResponse;
import com.invo.matchela.core.dto.RestResponseDto;
import com.invo.matchela.web.rest.controller.user.UserFavCategoryController;
import com.invo.matchela.api.dto.UserFavCategoryDTO;
import com.invo.matchela.api.mapper.UserFavCategoryMapper;
import com.invo.matchela.api.service.UserFavCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/v1/user-fav-category")
@RestController
public class UserFavCategoryControllerImpl implements UserFavCategoryController {
    private final UserFavCategoryService userFavCategoryService;
    private final UserFavCategoryMapper userFavCategoryMapper;

    public UserFavCategoryControllerImpl(UserFavCategoryService userFavCategoryService, UserFavCategoryMapper userFavCategoryMapper) {
        this.userFavCategoryService = userFavCategoryService;
        this.userFavCategoryMapper = userFavCategoryMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserFavCategoryDTO save(@RequestBody UserFavCategoryDTO userFavCategoryDTO) {
        UserFavCategory userFavCategory = userFavCategoryMapper.asEntity(userFavCategoryDTO);
        return userFavCategoryMapper.asDTO(userFavCategoryService.save(userFavCategory));
    }

    @Override
    @PutMapping(value = "save-all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<UserFavCategoryDTO> saveAll(@RequestBody List<UserFavCategoryDTO> userFavCategoryDTO) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        List<UserFavCategory> userFavCategory = userFavCategoryMapper.asEntityList(userFavCategoryDTO);
        return userFavCategoryMapper.asDTOList(userFavCategoryService.saveAll(userFavCategory));
    }

    @Override
    @PostMapping(value = "save-all")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> saveAllByIds(@RequestBody List<Long> userFavCategoryDTO) {
        userFavCategoryService.addMultipleCategory(userFavCategoryDTO);
        return MatchResponse.successResponse(new UserFavCategoryDTO());
    }

    @Override
    @GetMapping("/{id}")
    public UserFavCategoryDTO findById(@PathVariable("id") Long id) {
        UserFavCategory userFavCategory = userFavCategoryService.findById(id).orElse(null);
        return userFavCategoryMapper.asDTO(userFavCategory);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userFavCategoryService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<UserFavCategoryDTO> list() {
        return userFavCategoryMapper.asDTOList(userFavCategoryService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<UserFavCategoryDTO> pageQuery(Pageable pageable) {
        Page<UserFavCategory> userFavCategoryPage = userFavCategoryService.findAll(pageable);
        List<UserFavCategoryDTO> dtoList = userFavCategoryPage
                .stream()
                .map(userFavCategoryMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, userFavCategoryPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public UserFavCategoryDTO update(@RequestBody UserFavCategoryDTO userFavCategoryDTO, @PathVariable("id") Long id) {
        UserFavCategory userFavCategory = userFavCategoryMapper.asEntity(userFavCategoryDTO);
        return userFavCategoryMapper.asDTO(userFavCategoryService.update(userFavCategory, id));
    }
}