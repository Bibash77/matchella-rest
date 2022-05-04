package com.invo.matchela.core.authorization.refreshtoken.service;


import com.invo.matchela.core.authorization.user.User;
import com.invo.matchela.core.authorization.user.repository.UserRepository;
import com.invo.matchela.core.authorization.refreshtoken.model.RefreshToken;
import com.invo.matchela.core.authorization.refreshtoken.repository.RefreshTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * @author : Rujan Maharjan on  6/12/2021
 **/
@Service
public class RefreshTokenService {

    @Value("${jwt.refreshExpirationDateInMs}")
    private Long refreshTokenDurationMs;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private UserRepository userRepository;

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken createRefreshToken(Long userId, String deviceId) {
        RefreshToken refreshToken = new RefreshToken();
        Optional<RefreshToken> refreshTokenOPT = refreshTokenRepository.findByUserIdAndDeviceId(userId, deviceId);
        refreshToken.setDeviceId(deviceId);
        if (!refreshTokenOPT.isPresent()) {
            return createRefreshToken(userId, refreshToken);
        } else {
            try {
                return verifyExpiration(refreshTokenOPT.get());
            } catch (BadCredentialsException e) {
                return createRefreshToken(userId, refreshToken);
            }
        }
    }

    private RefreshToken createRefreshToken(Long userId, RefreshToken refreshToken) {
        User userById = userRepository.findUserById(userId);
        if (Objects.isNull(userById)) {
            throw new BadCredentialsException("UserId doesn't exist");
        }
        refreshToken.setUserId(userId);
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken = refreshTokenRepository.save(refreshToken);
        return refreshToken;
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new BadCredentialsException("Refresh token was expired. Please make a new signin request");
        }
        return token;
    }

    @Transactional
    public int deleteByUserId(Long userId) {
        return refreshTokenRepository.deleteRefreshTokenByUserId(userId);
    }

}
