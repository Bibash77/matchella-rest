package com.invo.matchela.authorization.accesstoken.model;

import lombok.Data;

import java.util.List;

/**
 * @author : Rujan Maharjan on  6/12/2021
 **/

@Data
public class JwtResponse {

    private String access_token;
    private String token_type = "Bearer";
    private String refresh_token;
    private Long id;
    private String username;
    private String email;
    private List<String> roles;


    public JwtResponse(String accessToken, String refreshToken, String username, String email, List<String> roles) {
        this.access_token = accessToken;
        this.refresh_token = refreshToken;
        this.username = username;
        this.email = email;
        this.roles = roles;

    }
}
