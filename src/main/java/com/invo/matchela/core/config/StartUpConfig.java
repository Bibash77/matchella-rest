package com.invo.matchela.core.config;

import com.invo.matchela.core.authorization.user.User;
import com.invo.matchela.core.authorization.user.repository.UserRepository;
import com.invo.matchela.core.enums.AppConstant;
import com.invo.matchela.core.enums.RoleType;
import com.invo.matchela.core.enums.Status;
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
       // final User admin = userRepository.findUserByUserName(AppConstant.DEFAULT_SUPER_ADMIN_USERNAME);

             User user = new User();
            user.setFullName(AppConstant.DEFAULT_SUPER_ADMIN_NAME);
            user.setUsername(AppConstant.DEFAULT_SUPER_ADMIN_USERNAME);
            user.setUserCode(AppConstant.DEFAULT_SUPER_ADMIN_USERNAME);
            user.setPassword(passwordEncoder.encode(AppConstant.DEFAULT_SUPER_ADMIN_PASSWORD));
            user.setStatus(Status.ACTIVE);
            user.setEmail("demo@gmail.com");
            user.setRoleType(RoleType.ADMIN);
            user.setUserCode("123456");
            user.setLogin("ted");
            userRepository.save(user);

    }
}
