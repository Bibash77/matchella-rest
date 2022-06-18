package com.invo.matchela.core.config;

import com.invo.matchela.core.CustomAuditAware;
import com.invo.matchela.core.authorization.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditorConfig {
    @Bean
    public AuditorAware<Long> auditorAware(){
        return new CustomAuditAware();
    }
}
