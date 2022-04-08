package com.bibash.invo.api.dto;

import lombok.Data;

@Data
public class PasswordChangeDto {

	private String email;
	private String password;
	private String token;
}
