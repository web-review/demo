package com.example.demo.core.repository;

import com.example.demo.core.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserById(Long id);
    User getUserByUsername(String username);
    User getUserByRole(String role);
}
