package com.invo.matchela.web.rest.controller.user.impl;

import java.util.Date;

import com.invo.matchela.api.dto.LoginDto;
import com.invo.matchela.api.dto.UserDto;
import com.invo.matchela.core.authorization.user.Service.UserService;
import com.invo.matchela.core.authorization.user.User;
import com.invo.matchela.core.dto.MatchResponse;
import com.invo.matchela.core.enums.RoleType;
import com.invo.matchela.core.enums.Status;
import com.invo.matchela.api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserControllerImpl {

    private UserService userService;

    @Autowired
    private LoginService loginService;

    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/authenticated")
    public ResponseEntity<?> getAuthenticated() {
        return MatchResponse.successResponse(userService.getAuthenticated());
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        return MatchResponse.successResponse(userService.save(user));
    }

    @GetMapping(value = "all")
    public ResponseEntity<?> getAll() {
        return MatchResponse.successResponse(userService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        return MatchResponse.successResponse(userService.findOne(id));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        user.setStatus(Status.INACTIVE);
        user.setRoleType(RoleType.STUDENT);
        return MatchResponse.successResponse(new User());
    }

    @PostMapping(value = "/status")
    public ResponseEntity<?> changeUserStatus(@RequestBody User user) {
        return MatchResponse.successResponse(userService.changeStatus(user));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        UserDto userDto = loginService.loginChecking(loginDto);
        if(userDto != null){
            return MatchResponse.successResponse(userDto);
        }
       return MatchResponse.successResponse("username or password invalid");
    }

    @GetMapping("/countUser")
    public ResponseEntity<?> countUser(@RequestParam String startDate , @RequestParam String endDate) {
        return MatchResponse.successResponse(userService.countUser(new Date(startDate), new Date(endDate), Status.INACTIVE));
    }
}
