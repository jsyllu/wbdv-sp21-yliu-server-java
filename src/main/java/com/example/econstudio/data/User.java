package com.example.econstudio.data;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class User {
    private String username;
    private String password;

    @PostMapping("/api/user")
    public User createUser (@RequestBody User newUser) {
        return newUser;
    }
}
