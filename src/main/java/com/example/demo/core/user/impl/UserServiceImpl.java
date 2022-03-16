package com.example.demo.core.user.impl;

import com.example.demo.core.UserService;
import com.example.demo.core.repository.UserRepository;
import com.example.demo.core.user.User;
import com.example.demo.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Access;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = new User(userDto.getId(),
                userDto.getUsername(),
                userDto.getRole());
        userRepository.save(user);
        return userDto;
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user = userRepository.getUserById(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setRole(userDto.getRole());
        userRepository.save(user);
        return userDto;
    }

    @Override
    public UserDto updateUsername(UserDto userDto) {
        User user = userRepository.getUserById(userDto.getId());
        user.setUsername(userDto.getUsername());
        userRepository.save(user);
        return userDto;
    }

    @Override
    public UserDto updateRole(UserDto userDto) {
        User user = userRepository.getUserById(userDto.getId());
        user.setRole(userDto.getRole());
        userRepository.save(user);
        return userDto;
    }

    @Override
    public UserDto getUserByUsername(UserDto userDto) {
        User user = userRepository.getUserByUsername(userDto.getUsername());
        userDto.setRole(user.getRole());
        return userDto;
    }

    @Override
    public UserDto getUserByRole(UserDto userDto) {
        User user = userRepository.getUserByRole(userDto.getRole());
        userDto.setUsername(user.getUsername());
        return userDto;
    }

    @Override
    public UserDto removeUserById(UserDto userDto) {
        User user = userRepository.getUserById(userDto.getId());
        userDto.setUsername(user.getUsername());
        userDto.setRole(user.getRole());
        userRepository.delete(user);
        return userDto;
    }

    @Override
    public UserDto removeUserByUsername(UserDto userDto) throws NullPointerException {
        if(userRepository.getUserByUsername(userDto.getUsername()) == null) {
            return userDto;
        }
        User user = userRepository.getUserByUsername(userDto.getUsername());
        userDto.setUsername(user.getUsername());
        userDto.setRole(user.getRole());
        userRepository.delete(user);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> usersDto = new ArrayList<>();
        for (User user: userRepository.findAll()) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setRole(user.getRole());
            userDto.setUsername(user.getUsername());
            usersDto.add(userDto);
        }
        return usersDto;
    }
}
