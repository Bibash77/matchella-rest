package com.invo.matchela.api.dto;

import com.invo.matchela.core.enums.Gender;
import com.invo.matchela.core.enums.RoleType;
import com.invo.matchela.core.enums.Status;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserDto {

    private Long id;

    private String userName;
    private String firstName;
    private String lastName;

    private Gender gender;

    private Status status;

    private String fullName;

    private String email;

    private LocalDate birthDate;
    private Double confirmationCode;
    List<UserFavCategoryDTO> userFavCategory;
}
