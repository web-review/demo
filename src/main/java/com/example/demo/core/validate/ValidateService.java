package com.example.demo.core.validate;

import com.example.demo.core.repository.UserRepository;
import com.example.demo.core.user.User;
import com.example.demo.web.dto.UserDto;
import org.apache.catalina.util.ErrorPageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidateService {
    UserRepository userRepository;

    @Autowired
    public ValidateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isValidUsername(UserDto userDto, Boolean match)
    {
        String regex = "^[A-Za-z]\\w{5,29}$";
        Pattern pattern = Pattern.compile(regex);
        if (userDto.getUsername() == null || userDto.getUsername().equals("")) {return false;}
        if(!runMatch(userDto, match)) return false;
        Matcher matcher = pattern.matcher(userDto.getUsername());
        return matcher.matches();
    }

    public boolean isMatchUsername(UserDto userDto) {
        for (User user : userRepository.findAll()) {
            if (user.getUsername().equals(userDto.getUsername())) {
                return false;
            }
        }
        return true;
    }

    private boolean runMatch(UserDto userDto, Boolean match) {
        if(!isMatchUsername(userDto) && match)  {return false;}
        return true;
    }
}
