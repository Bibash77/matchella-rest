package com.invo.matchela.api.mapper;

import com.invo.matchela.api.entity.cards.CardCategory;
import com.invo.matchela.api.dto.CardCategoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface CardCategoryMapper extends GenericMapper<CardCategory, CardCategoryDTO> {
}