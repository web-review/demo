package com.example.demo.web.controller.view;

import com.example.demo.web.dto.UserDto;
import org.springframework.web.servlet.ModelAndView;

public interface ViewController {
    ModelAndView getIndexPage();
    String getAboutPage();
    public String save(UserDto userDto);
}
