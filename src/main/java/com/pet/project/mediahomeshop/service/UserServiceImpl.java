package com.pet.project.mediahomeshop.service;

import com.pet.project.mediahomeshop.entity.User;
import com.pet.project.mediahomeshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        if( userRepository.existsUserByEmail(user.getEmail()) ) {
            throw new RuntimeException("Email already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        return userRepository.save(user);
    }

    @Override
    public User login(User userReq) {
        User user = userRepository.getUserByEmail(userReq.getEmail());

        if (user == null) {
            return null;
        }

        if (passwordEncoder.matches(userReq.getPassword(), user.getPassword())) {
            return user;
        }

        return null;
    }
}
