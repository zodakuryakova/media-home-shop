package com.pet.project.mediahomeshop.repository;

import com.pet.project.mediahomeshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User  getUserByEmail(String email);

    boolean existsUserByEmail(String email);
}
