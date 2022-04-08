package com.bibash.invo.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.bibash.invo.api.user.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

   public Double walletAmount;
    public User user;
}
