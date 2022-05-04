package com.invo.matchela.core.authorization.accesstoken.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * @author Rujan Maharjan on 2021-12-27
 */
@Entity
@Getter
@Setter
public class AccessToken {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private String deviceId="def";

    @Lob
    private String accessToken;

}
