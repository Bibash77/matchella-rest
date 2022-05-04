package com.invo.matchela.api.mapper;

import com.invo.matchela.api.entity.cards.Card;
import com.invo.matchela.api.dto.CardDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface CardMapper extends GenericMapper<Card, CardDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    Card asEntity(CardDTO dto);
}