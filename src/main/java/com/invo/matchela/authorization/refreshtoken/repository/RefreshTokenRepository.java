package com.invo.matchela.authorization.refreshtoken.repository;



import com.invo.matchela.authorization.refreshtoken.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    @Override
    Optional<RefreshToken> findById(Long id);

    Optional<RefreshToken> findByToken(String token);

    int deleteRefreshTokenByUserId(Long id);

    Optional<RefreshToken> findByUserIdAndDeviceId(Long userId,String DevicesId);

    Optional<RefreshToken> findByUserId(Long id);


}
