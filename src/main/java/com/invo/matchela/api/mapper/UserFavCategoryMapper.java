package com.invo.matchela.api.mapper;

import com.invo.matchela.api.entity.cards.UserFavCategory;
import com.invo.matchela.api.dto.UserFavCategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface UserFavCategoryMapper extends GenericMapper<UserFavCategory, UserFavCategoryDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    UserFavCategory asEntity(UserFavCategoryDTO dto);

    @Override
    @Mapping(target = "id", ignore = false)
    List<UserFavCategory> asEntityList(List<UserFavCategoryDTO> dto);
}