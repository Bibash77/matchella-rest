package com.bibash.invo.api.dto;

import com.bibash.invo.api.user.User;
import lombok.Data;

@Data
public class BaseRegisterDto {
	
	private User user;
	private RegisterDto registerDto;
	
}