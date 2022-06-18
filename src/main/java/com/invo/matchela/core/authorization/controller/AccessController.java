package com.invo.matchela.core.authorization.controller;

import com.invo.matchela.core.authorization.user.User;
import com.invo.matchela.core.authorization.user.repository.UserRepository;
import com.invo.matchela.core.authorization.accesstoken.model.JwtResponse;
import com.invo.matchela.core.authorization.accesstoken.model.LoginRequest;
import com.invo.matchela.core.authorization.accesstoken.repository.AccessTokenRepository;
import com.invo.matchela.core.authorization.accesstoken.service.AccessTokenService;
import com.invo.matchela.core.authorization.jwt.JwtUtil;
import com.invo.matchela.core.authorization.refreshtoken.model.RefreshToken;
import com.invo.matchela.core.authorization.refreshtoken.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/oauth")
public class AccessController {

    private static final String LOGIN_VALID_PARAMS = "username,password";
    private final AuthenticationManager authenticationManager;

    private final RefreshTokenService refreshTokenService;


    private final JwtUtil jwtUtil;

    private final AccessTokenRepository accessTokenRepository;

    private final AccessTokenService accessTokenService;

    private final UserRepository userRepository;


    @PostMapping(path = "/token",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})

    public ResponseEntity<JwtResponse> authenticateUser(LoginRequest loginRequest) {
        User user;
        try {
            log.info("attempting LOGIN:::  {}", loginRequest.getUsername());
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            user = (User) userDetails;
            if (ObjectUtils.isEmpty(user)) {
                throw new BadCredentialsException("INVALID CREDENTIALS");
            }

        } catch (DisabledException | BadCredentialsException e) {
            throw new BadCredentialsException("INVALID CREDENTIALS");
        }

        String deviceId = loginRequest.getDeviceId();
        if (Objects.isNull(deviceId)) {
            deviceId = "def";
        }

        List<String> roles = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getId(), deviceId);
        String token = accessTokenService.createToken(user, deviceId);
        JwtResponse response = new JwtResponse(token, refreshToken.getToken(), user.getUsername(), user.getEmail(), roles, user.getId(), user.getFullName());
        return ResponseEntity.ok(response);
    }
}
