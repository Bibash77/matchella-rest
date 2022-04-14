package com.invo.matchela.api.user;

import java.io.Serializable;
import java.time.Instant;
import java.util.Collection;

import com.invo.matchela.core.BaseEntity;
import com.invo.matchela.core.component.TextEncryptorConverter;
import com.invo.matchela.core.constants.Constants;
import com.invo.matchela.core.enums.RoleType;
import com.invo.matchela.core.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User extends BaseEntity<Long> implements UserDetails , Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name = "Full_Name")
    private String fullName;

    @Column(nullable = false)
    private RoleType roleType;

    @Column(nullable = false)
    private String userCode;

    @Column(nullable = false)
    private String password;


    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;

    @NotNull
    @Column(nullable = false)
    private boolean activated = false;

    @Size(max = 256)
    @Column(name = "image_url", length = 256)
    private String imageUrl;

    @Size(max = 20)
    @Column(name = "reset_key", length = 20)
    @JsonIgnore
    private String resetKey;

    @Column(name = "reset_date")
    private Instant resetDate = null;


    private String number;


    @Column(nullable = false, unique = true, updatable = false)
    @Convert(converter = TextEncryptorConverter.class)
    private String email;

    @Enumerated(EnumType.ORDINAL)
    private Status status;


    @NotBlank
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    private String login;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status == Status.ACTIVE;
    }
}