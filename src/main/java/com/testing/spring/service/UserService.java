package com.testing.spring.service;

import com.testing.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String getUserId(long id) {
        return userRepository.getUserNameById(id);
    }
}
