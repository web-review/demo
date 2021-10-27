package com.example.demo.web.controller.view.impl;

import com.example.demo.web.controller.view.ViewController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class ViewControllerImpl implements ViewController {

    @Override
    @GetMapping("/index")
    public String getIndexPage() {
        return "index";
    }

    @Override
    @GetMapping("/about")
    public String getAboutPage() {
        return "about";
    }
}
