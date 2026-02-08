package com.lux.todoapi.resolver;

import com.lux.todoapi.dto.LoginResponse;
import com.lux.todoapi.service.AuthService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthResolver {

    private final AuthService authService;

    public AuthResolver(AuthService authService) {
        this.authService = authService;
    }

    @MutationMapping
    public LoginResponse login(@Argument String email) {
        return authService.login(email);
    }
}
