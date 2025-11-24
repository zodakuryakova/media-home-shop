package com.pet.project.mediahomeshop.controller;

import com.pet.project.mediahomeshop.entity.User;
import com.pet.project.mediahomeshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        User user1 = userService.save(user);

        if (user1 == null) {
            throw new RuntimeException("Can not register user");
        }

        return "Register successful";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User user1 = userService.login(user);

        return user1 != null ? "Login successful" : "Login failed";
    }
}
