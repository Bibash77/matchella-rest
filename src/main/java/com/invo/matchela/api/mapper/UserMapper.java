package com.invo.matchela.api.mapper;

import com.invo.matchela.api.dto.RegisterDto;
import com.invo.matchela.api.dto.UserDto;
import com.invo.matchela.core.authorization.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface UserMapper extends GenericMapper<User, UserDto> {

    @Override
    @Mapping(target = "id", ignore = false)
    User asEntity(UserDto dto);
}
