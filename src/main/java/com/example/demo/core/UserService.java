package com.example.demo.core;

import com.example.demo.web.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto);
    UserDto update(UserDto userDto);
    UserDto updateUsername(UserDto userDto);
    UserDto updateRole(UserDto userDto);
    UserDto getUserByUsername(UserDto userDto);
    UserDto getUserByRole(UserDto userDto);
    UserDto removeUserById(UserDto userDto);
    UserDto removeUserByUsername(UserDto userDto);
    List<UserDto> getAllUsers();
}
