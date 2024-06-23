package com.primshic.stepan.service;

import com.primshic.stepan.dto.UserResponse;
import com.primshic.stepan.model.User;
import com.primshic.stepan.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    public UserResponse findByEmail(String username) {
        Optional<User> optionalUser =  repository.findByEmail(username);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            return new UserResponse(user.getId(),user.getEmail());
        } else throw new UsernameNotFoundException("Not authenticated");
    }
}
