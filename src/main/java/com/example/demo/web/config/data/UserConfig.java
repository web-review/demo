package com.example.demo.web.config.data;

import com.example.demo.core.UserService;
import com.example.demo.core.user.impl.UserServiceImpl;
import com.example.demo.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    UserService userService;

    @Autowired
    public UserConfig(UserServiceImpl userService) {
        this.userService = userService;
    }
    
    @Bean
    public void createUser() {
        UserDto userDto = new UserDto();
        userDto.setUsername("Peiler");
        userDto.setRole("Java Web Developer");
        userService.save(userDto);
    }
}
