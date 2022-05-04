package com.invo.matchela.api.entity.mapper;

import com.invo.matchela.api.entity.cards.CardCategory;
import com.invo.matchela.api.entity.dto.CardCategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CardCategoryMapper extends EntityMapper<CardCategoryDto, CardCategory> {
}