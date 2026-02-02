package com.lux.todoapi.graphql.UserMutation;

import com.lux.todoapi.entity.User;
import com.lux.todoapi.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserMutation {

    private final UserService userService;

    public UserMutation(UserService userService) {
        this.userService = userService;
    }

    @MutationMapping
    public User createUser(@Argument String email, @Argument String name) {
        return userService.createUser(email, name);
    }
}
