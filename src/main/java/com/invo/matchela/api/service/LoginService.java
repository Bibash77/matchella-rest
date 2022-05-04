package com.invo.matchela.api.service;

import com.invo.matchela.core.authorization.user.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.invo.matchela.core.authorization.user.Service.UserService;
import com.invo.matchela.api.dto.LoginDto;
import com.invo.matchela.api.dto.UserDto;

@Component
public class LoginService {
    @Autowired
    private UserService userService;


    public UserDto loginChecking(LoginDto loginDto){
        User user = userService.findUserByName(loginDto.getUserName());
            if(!ObjectUtils.isEmpty(user)){
            UserDto userDto = new UserDto();
                BeanUtils.copyProperties(user , userDto);
            if(user.getPassword().equals(loginDto.getPassword())){
                return userDto;
            }
        }
        return null;
    }
}
