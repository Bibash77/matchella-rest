package com.invo.matchela.core.authorization.user.Service;

import java.util.Date;
import java.util.Map;

import com.invo.matchela.api.dto.UserDto;
import com.invo.matchela.core.authorization.user.User;
import com.invo.matchela.core.BaseService;
import com.invo.matchela.core.enums.Status;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  extends BaseService<User>,UserDetailsService {

    public String userCodeGenerateor();

    public User changeStatus(User user);

    public User findUserByName(String userName);

    Map<String , Long> countUser(Date startDate, Date endDate, Status status);

    public User findById(Long userId);

    User getAuthenticated();

    void registerUser(UserDto user);
}
