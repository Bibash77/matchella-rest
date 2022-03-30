package com.bibash.matchella.core.config;

import com.bibash.matchella.api.user.User;
import com.bibash.matchella.api.user.repository.UserRepository;
import com.bibash.matchella.core.enums.AppConstant;
import com.bibash.matchella.core.enums.RoleType;
import com.bibash.matchella.core.enums.Status;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StartUpConfig {

    private final UserRepository userRepository;


    private final PasswordEncoder passwordEncoder;

    public StartUpConfig(UserRepository userRepository,

                         PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        System.out.println();
    }

    @PostConstruct
    public void populate() {
        createSuperAdmin();
    }

    private void createSuperAdmin() {
//        final User admin = userRepository.findUserByUserName(AppConstant.DEFAULT_SUPER_ADMIN_USERNAME);
//        if (admin == null) {
//            final User user = new User();
//            user.setFullName(AppConstant.DEFAULT_SUPER_ADMIN_NAME);
//            user.setUserName(AppConstant.DEFAULT_SUPER_ADMIN_USERNAME);
//            user.setPassword(passwordEncoder.encode(AppConstant.DEFAULT_SUPER_ADMIN_PASSWORD));
//            user.setStatus(Status.ACTIVE);
//            user.setEmail("demo@gmail.com");
//            user.setRoleType(RoleType.ADMIN);
//            user.setUserCode("123456");
//        }
    }
}
