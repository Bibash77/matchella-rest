package com.invo.matchela.authorization.user.Service;

import java.util.Date;
import java.util.Map;

import com.invo.matchela.authorization.user.User;
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
}
