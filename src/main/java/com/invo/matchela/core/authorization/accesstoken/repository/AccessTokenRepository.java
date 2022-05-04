package com.invo.matchela.core.authorization.accesstoken.repository;

import com.invo.matchela.core.authorization.accesstoken.model.AccessToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rujan Maharjan on 2021-12-27
 */
@Repository
public interface AccessTokenRepository extends JpaRepository<AccessToken,Long> {
    AccessToken findAccessTokenByUserIdAndDeviceId(Long userId, String deviceId);
    void deleteAccessTokenByUserId(Long userId);
}
