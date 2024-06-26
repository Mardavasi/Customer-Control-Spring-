package com.customer.customer.controllers;


import com.customer.customer.dto.RequestLogin;
import com.customer.customer.entities.User;
import com.customer.customer.services.AuthService;
import com.customer.customer.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/auth/login")
    public String login (@RequestBody RequestLogin request){
        String email = request.getEmail();
        String password = request.getPassword();
        User user = service.login(email,password);
        String token = JwtUtil.generateToken(user);
        return token;

    }
}
