package com.example.demo.web.controller;

import com.example.demo.web.dto.UserDto;

public interface UserController {
    UserDto save(UserDto userDto);
    UserDto update(UserDto userDto);
    UserDto updateUsername(UserDto userDto);
    UserDto updateRole(UserDto userDto);
    UserDto getUserByUsername(UserDto userDto);
    UserDto getUserByRole(UserDto userDto);
    UserDto removeUserById(UserDto userDto);
}
