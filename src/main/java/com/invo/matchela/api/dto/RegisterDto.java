package com.invo.matchela.api.dto;

import com.invo.matchela.core.enums.Gender;
import com.invo.matchela.core.enums.Status;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class RegisterDto extends AbstractDTO<Long>{
	
	private String password;
	private String referrerCode;
	private boolean termsConditions;
	private boolean privacy;

	private String userName;
	private String firstName;
	private String lastName;

	private Gender gender;

	private Status status;

	private String fullName;

	private String email;

	private LocalDate dateOfBirth;
	private Double confirmationCode;
	List<UserFavCategoryDTO> userFavCategory;
}
