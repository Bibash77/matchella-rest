package com.invo.matchela.core.authorization.user.Service;

import com.invo.matchela.api.dto.UserDto;
import com.invo.matchela.api.entity.cards.UserFavCategory;
import com.invo.matchela.api.mapper.UserMapper;
import com.invo.matchela.api.service.UserFavCategoryService;
import com.invo.matchela.core.authorization.user.User;
import com.invo.matchela.core.authorization.user.UserRegisterProcessor;
import com.invo.matchela.core.authorization.user.repository.UserRepository;
import com.invo.matchela.core.config.exception.CustomException;
import com.invo.matchela.core.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("userDetailService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private  UserRegisterProcessor userRegisterProcessor;


    private final UserMapper userMapper;
    private final UserFavCategoryService userFavCategoryService;

    public UserServiceImpl(UserMapper userMapper, UserFavCategoryService userFavCategoryService) {
        this.userMapper = userMapper;
        this.userFavCategoryService = userFavCategoryService;
    }


    @Override
    public List findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User save(User user) {
        try {
            if (user.getId() == null) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                user.setUserCode(userCodeGenerateor());
                user.setStatus(Status.INACTIVE);
            }
            return userRepository.save(user);
        } catch (Exception e) {
            throw new CustomException(
                    "User with username: " + user.getUsername() + " already exist!!!");
        }
    }

    @Override
    public Page findAllPageable(Object t, Pageable pageable) {
        return null;
    }

    @Override
    public List saveAll(List list) {
        return null;
    }

    @Override
    public String userCodeGenerateor() {
        String userCode = String.valueOf(new Random().nextInt(1000)).concat(new Date().getDate() + String.valueOf(new Date().getSeconds()));
        return userCode;
    }

    @Override
    public User changeStatus(User user) {
        User user1 = userRepository.getOne(user.getId());
        user1.setStatus(user.getStatus());
        user1.setRoleType(user.getRoleType());

        return userRepository.save(user1);
    }

    @Override
    public User findUserByName(String userName) {
        return userRepository.findUserByUsername(userName);
    }

    @Override
    public Map<String, Long> countUser(Date startDate, Date endDate, Status status) {
        return userRepository.countUsers(status);
    }

    @Override
    public User findById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElse(null);
    }

    @Override
    public User getAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            User user = (User) authentication.getPrincipal();
            user = this.findUserByName(user.getUsername());
            return user;
        } else {
            throw new UsernameNotFoundException("User is not Authenticated; Found type: " + authentication.getPrincipal().getClass());
        }
    }

    @Override
    public void registerUser(UserDto userDto) {
        User user = userMapper.asEntity(userDto);
        userFavCategoryService.save(userRegisterProcessor.processRegisterFav(user.getUserFavCategories()));
        save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUsersByUsername(username);


    }

}
