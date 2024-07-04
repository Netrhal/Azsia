package com.study.azsia.services;

import com.study.azsia.repositories.UserRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}
