package com.invo.matchela.api.dto;

import com.invo.matchela.core.authorization.user.User;
import lombok.Data;

@Data
public class BaseRegisterDto {
	
	private User user;
	private RegisterDto registerDto;
	
}
