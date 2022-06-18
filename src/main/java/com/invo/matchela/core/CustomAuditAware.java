package com.invo.matchela.core;

import com.invo.matchela.core.authorization.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class CustomAuditAware implements AuditorAware<Long> {

    @Bean
    public Optional<Long> getCurrentAuditor() {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            if(!(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User)){
                return Optional.of(0L);
            }
            User auth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if(auth != null) {
                return Optional.of(auth.getId());
            } else {
                return Optional.of(0L);
            }
        } else {
            return Optional.empty();
        }
    }

}
