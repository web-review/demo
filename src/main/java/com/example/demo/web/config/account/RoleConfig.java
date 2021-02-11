package com.example.demo.web.config.account;

import com.example.demo.core.account.Role;
import com.example.demo.core.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleConfig {
    @Autowired
    private RoleRepository roleRepository;

    @Bean
    public void OneRoleInit() {
        Role userRole = new Role("user");
        roleRepository.save(userRole);
    }
}
