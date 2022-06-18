package com.invo.matchela.api.entity.mapper;

import com.invo.matchela.api.entity.cards.MatchRequest;
import com.invo.matchela.api.entity.dto.MatchRequestDTO;
import com.invo.matchela.api.mapper.GenericMapper;
import com.invo.matchela.api.mapper.ReferenceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface MatchRequestMapper extends GenericMapper<MatchRequest, MatchRequestDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    MatchRequest asEntity(MatchRequestDTO dto);
}