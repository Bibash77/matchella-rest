package com.invo.matchela.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.invo.matchela.core.constants.StringConstants;
import com.invo.matchela.core.enums.Gender;
import com.invo.matchela.core.enums.RoleType;
import com.invo.matchela.core.enums.Status;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
public class UserDto {

    private Long id;

    @Size(min = StringConstants.DEFAULT_MIN_SIZE_4)
    private String username;

    private String firstName;

    @Size(min = StringConstants.DEFAULT_MIN_PASSWORD_SIZE)
    private String password;

    private String lastName;

    private Gender gender;

    private Status status;

    @Size(min = StringConstants.DEFAULT_MAX_SIZE_6)
    private String fullName;

    @Email
    private String email;

    private LocalDate dateOfBirth;
    private Double confirmationCode;
    List<UserFavCategoryDTO> userFavCategory;
}
