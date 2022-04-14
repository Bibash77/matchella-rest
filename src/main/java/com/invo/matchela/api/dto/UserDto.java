package com.invo.matchela.api.dto;

import com.invo.matchela.core.enums.RoleType;
import com.invo.matchela.core.enums.Status;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String userName;

    private String token;

    private RoleType roleType;

    private Double walletAmount;

    private Status status;

    private String userCode;

    private String fullName;

    private String email;

    private String batch;
}
