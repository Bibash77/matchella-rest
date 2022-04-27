package com.invo.matchela.core.dto;

import com.invo.matchela.authorization.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

   public Double walletAmount;
    public User user;
}
