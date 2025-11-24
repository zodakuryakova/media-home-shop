package com.pet.project.mediahomeshop.service;

import com.pet.project.mediahomeshop.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User save(User user);
    public User login(User user);

}
