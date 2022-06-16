package com.invo.matchela.core.authorization.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.invo.matchela.api.entity.cards.UserFavCategory;
import com.invo.matchela.core.AuditActiveAbstract;
import com.invo.matchela.core.BaseEntity;
import com.invo.matchela.core.component.TextEncryptorConverter;
import com.invo.matchela.core.constants.Constants;
import com.invo.matchela.core.enums.Gender;
import com.invo.matchela.core.enums.RoleType;
import com.invo.matchela.core.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User extends AuditActiveAbstract implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "gender")
    private Gender gender;

    private LocalDate dateOfBirth;

    @Column(name = "user_name", unique = true, nullable = false)
    private String username;

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

    @Transient
    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private Set<UserFavCategory> userFavCategories;


    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    private String login;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();


        authorities.addAll(AuthorityUtils.createAuthorityList("ADMIN","USER"));

        return authorities;
    }


    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
