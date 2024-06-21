package com.customer.customer.services;

import com.customer.customer.entities.User;
import org.springframework.stereotype.Service;


public interface AuthService {
    User login(String email, String password);
}
