package com.invo.matchela.web.rest.controller.card.impl;

import com.invo.matchela.api.entity.cards.CardCategory;
import com.invo.matchela.web.rest.controller.card.CardCategoryController;
import com.invo.matchela.api.dto.CardCategoryDTO;
import com.invo.matchela.api.mapper.CardCategoryMapper;
import com.invo.matchela.api.service.CardCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/card-category")
@RestController
public class CardCategoryControllerImpl implements CardCategoryController {
    private final CardCategoryService cardCategoryService;
    private final CardCategoryMapper cardCategoryMapper;

    public CardCategoryControllerImpl(CardCategoryService cardCategoryService, CardCategoryMapper cardCategoryMapper) {
        this.cardCategoryService = cardCategoryService;
        this.cardCategoryMapper = cardCategoryMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CardCategoryDTO save(@RequestBody CardCategoryDTO cardCategoryDTO) {
        CardCategory cardCategory = cardCategoryMapper.asEntity(cardCategoryDTO);
        return cardCategoryMapper.asDTO(cardCategoryService.save(cardCategory));
    }

    @Override
    @GetMapping("/{id}")
    public CardCategoryDTO findById(@PathVariable("id") Long id) {
        CardCategory cardCategory = cardCategoryService.findById(id).orElse(null);
        return cardCategoryMapper.asDTO(cardCategory);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        cardCategoryService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<CardCategoryDTO> list() {
        return cardCategoryMapper.asDTOList(cardCategoryService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<CardCategoryDTO> pageQuery(Pageable pageable) {
        Page<CardCategory> cardCategoryPage = cardCategoryService.findAll(pageable);
        List<CardCategoryDTO> dtoList = cardCategoryPage
                .stream()
                .map(cardCategoryMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, cardCategoryPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public CardCategoryDTO update(@RequestBody CardCategoryDTO cardCategoryDTO, @PathVariable("id") Long id) {
        CardCategory cardCategory = cardCategoryMapper.asEntity(cardCategoryDTO);
        return cardCategoryMapper.asDTO(cardCategoryService.update(cardCategory, id));
    }
}