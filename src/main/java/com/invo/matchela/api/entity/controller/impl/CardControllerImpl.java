package com.invo.matchela.api.entity.controller.impl;

import com.invo.matchela.api.entity.cards.Card;
import com.invo.matchela.api.entity.controller.CardController;
import com.invo.matchela.api.entity.dto.CardDTO;
import com.invo.matchela.api.entity.mapper.CardMapper;
import com.invo.matchela.api.entity.service.CardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/card")
@RestController
public class CardControllerImpl implements CardController {
    private final CardService cardService;
    private final CardMapper cardMapper;

    public CardControllerImpl(CardService cardService, CardMapper cardMapper) {
        this.cardService = cardService;
        this.cardMapper = cardMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CardDTO save(@RequestBody CardDTO cardDTO) {
        Card card = cardMapper.asEntity(cardDTO);
        return cardMapper.asDTO(cardService.save(card));
    }

    @Override
    @GetMapping("/{id}")
    public CardDTO findById(@PathVariable("id") Long id) {
        Card card = cardService.findById(id).orElse(null);
        return cardMapper.asDTO(card);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        cardService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<CardDTO> list() {
        return cardMapper.asDTOList(cardService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<CardDTO> pageQuery(Pageable pageable) {
        Page<Card> cardPage = cardService.findAll(pageable);
        List<CardDTO> dtoList = cardPage
                .stream()
                .map(cardMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, cardPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public CardDTO update(@RequestBody CardDTO cardDTO, @PathVariable("id") Long id) {
        Card card = cardMapper.asEntity(cardDTO);
        return cardMapper.asDTO(cardService.update(card, id));
    }
}