package com.example.demo.web.controller.impl;

import com.example.demo.core.UserService;
import com.example.demo.core.user.impl.UserServiceImpl;
import com.example.demo.web.controller.UserController;
import com.example.demo.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/")
public class UserControllerImpl implements UserController {
    private UserService userService;

    @Autowired
    public UserControllerImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping(value = "/save/user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto save(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @Override
    @PutMapping(value = "/update/user")
    public UserDto update(@RequestBody UserDto userDto) { return userService.update(userDto); }

    @Override
    @PatchMapping(value = "/update/user/username")
    public UserDto updateUsername(@RequestBody UserDto userDto) {
        return userService.updateUsername(userDto);
    }

    @Override
    @PatchMapping(value = "/update/user/role")
    public UserDto updateRole(@RequestBody UserDto userDto) {
        return userService.updateRole(userDto);
    }

    @Override
    @GetMapping(value = "/get/user/username")
    public UserDto getUserByUsername(@RequestBody UserDto userDto) {
        return userService.getUserByUsername(userDto);
    }

    @Override
    @GetMapping(value = "/get/user/role")
    public UserDto getUserByRole(@RequestBody UserDto userDto) {
        return userService.getUserByRole(userDto);
    }

    @Override
    @DeleteMapping(value = "/remove/user/id")
    public UserDto removeUserById(@RequestBody UserDto userDto) {
        return userService.removeUserById(userDto);
    }
}
