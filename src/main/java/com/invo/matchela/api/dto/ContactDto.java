package com.invo.matchela.api.dto;

import lombok.Data;

@Data
public class ContactDto {
	private String email;
	private String message;
	private String captchaText;
	private long captchaId;	
}
