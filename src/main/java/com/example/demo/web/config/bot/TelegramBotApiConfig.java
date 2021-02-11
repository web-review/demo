package com.example.demo.web.config.bot;

import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;

import javax.annotation.PostConstruct;

@Configuration
public class TelegramBotApiConfig {
    @PostConstruct
    public void ApiContextInit() {
        ApiContextInitializer.init();
    }
}
