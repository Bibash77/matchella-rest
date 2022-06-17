package com.invo.matchela.core.authorization.refreshtoken.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

/**
 * @author : Rujan Maharjan on  6/12/2021
 **/
@Entity(name = "refresh_token")
@Getter
@Setter
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false, unique = true)
    @Lob
    private String token;
    private String roleType;
    private String fullName;

    @Column(nullable = false)
    private Instant expiryDate;

    private String deviceId="def";

}

