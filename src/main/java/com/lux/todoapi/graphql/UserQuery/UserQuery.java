package com.lux.todoapi.graphql.UserQuery;

import com.lux.todoapi.entity.User;
import com.lux.todoapi.service.UserService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserQuery {

    private final UserService userService;

    public UserQuery(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    public List<User> users() {
        return userService.getAllUsers();
    }
}
