package com.example.demo.web.controller.view.impl;

import com.example.demo.core.UserService;
import com.example.demo.core.validate.ValidateService;
import com.example.demo.web.controller.view.ViewController;
import com.example.demo.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewControllerImpl implements ViewController {
    private final UserService userService;
    private final ValidateService validateService;

    @Autowired
    public ViewControllerImpl(UserService userService, ValidateService validateService) {
        this.userService = userService;
        this.validateService = validateService;
    }

    @PostMapping(value = "/edit", params="remove")
    public String remove(@ModelAttribute UserDto userDto) {
        ModelAndView mav = new ModelAndView("index");
        if(!validateService.isValidUsername(userDto, false)) {
            return "redirect:/";
        }
        mav.addObject("user", userDto);
        userService.removeUserByUsername(userDto);
        return "redirect:/";
    }

    @Override
    @PostMapping(value = "/edit")
    public String save(@ModelAttribute UserDto userDto) {
        ModelAndView mav = new ModelAndView("index");
        if(!validateService.isValidUsername(userDto, true)) {
            return "redirect:/";
        }
        mav.addObject("user", userDto);
        userService.save(userDto);
        //return mav;
        return "redirect:/";
    }

    @Override
    @GetMapping("/")
    public ModelAndView getIndexPage() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("users", userService.getAllUsers());
        return mav;
    }

    @Override
    @GetMapping("/about")
    public String getAboutPage() {
        return "about";
    }
}
