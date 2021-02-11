package com.example.demo.web.controller.impl;

import com.example.demo.web.config.bot.AudioBotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.BotSession;

public class TelegramBotApiController {
    private ConfigurableApplicationContext context;

    //output test telegram bot service
    /*
    public void testInfo() {
        AudioTelegramBotServiceImpl telegramBotServiceImpl = new AudioTelegramBotServiceImpl();
        showInfo(telegramBotServiceImpl);
    }
    public void getInfo(TelegramBotService service) {
        service.showInfo();
    }
    */

    public TelegramBotApiController() {
    }

    @Autowired
    public TelegramBotApiController(ConfigurableApplicationContext context) {
        this.context = context;
    }

    public void runAudioTelegramBotSession() throws TelegramApiException {
        AudioTelegramBot audioTelegramBot = new AudioTelegramBot(context);
        if (getRegisterTelegramBotSession(audioTelegramBot).isRunning()) {
            getRegisterTelegramBotSession(audioTelegramBot).stop();
        } else {
            getRegisterTelegramBotSession(audioTelegramBot).start();
        }
    }

    private BotSession getRegisterTelegramBotSession(AudioTelegramBot audioTelegramBot) throws TelegramApiException {
        audioTelegramBot.setBotUsername(AudioBotConfig.getBotName());
        audioTelegramBot.setBotToken(AudioBotConfig.getToken());
        return getNewTelegramBotsApi().registerBot(audioTelegramBot);
    }

    private TelegramBotsApi getNewTelegramBotsApi() {
        return new TelegramBotsApi();
    }
}

