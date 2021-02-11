package com.example.demo.web.controller.impl;

import com.example.demo.core.bot.impl.AudioTelegramBotServiceImpl;
import com.example.demo.web.dto.AudioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

@Component
public class AudioTelegramBot extends TelegramBot {
    private Update update;
    private ConfigurableApplicationContext context;


    public AudioTelegramBot() {
        super();
    }

    @Autowired
    public AudioTelegramBot(ConfigurableApplicationContext context) {
        this.context = context;
    }

    public AudioTelegramBot(String botUsername, String botToken) {
        super(botUsername, botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {
        this.update = update;
        onAudioChoiceReceived(update);
    }

    public void onAudioChoiceReceived(Update update) {
        try {
            switch (update.getMessage().getText()) {
                case "/gorillaz":
                    execute(sendAudio(update, "gorillaz", "m4a"));
                    break;
                case "/depeche":
                    execute(sendAudio(update, "depeche", "m4a"));
                    break;
                case "/save":
                    AudioTelegramBotServiceImpl service = context.getBean(AudioTelegramBotServiceImpl.class);
                    File testFile = new File("/home/dvasylev/Music/depeche.m4a");
                    AudioDto testDto = new AudioDto("'Depeche Mode", " - Enjoy the Silence'", testFile);
                    testDto.setAuthor("Depeche Mode");
                    testDto.setTitle("Enjoy the Silence");
                    testDto.setFile(testFile);
                    service.saveAudio(testDto);
                    System.out.println("Audio '" + testDto.getAuthor() + " - " + testDto.getTitle() + "' saved in table 'audios'");
                    sendMessage(testDto.getAuthor() + " - " +
                            testDto.getTitle() + "\n" + "\n" +
                            "Save audio on database. " + "\n");
                    break;
                default:
                    sendMessage("Command list: " + "\n" +
                            "1. '/gorillaz' " + "\n" +
                            "2. '/depeche' " + "\n" +
                            "3. '/save' ");
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String content) throws TelegramApiException {
        execute(new SendMessage()
                .setChatId(this.update.getMessage().getChatId())
                .setText(content));
    }

    public File getAudioFileByPath(String path) {
        return new File(path);
    }

    public SendAudio sendAudio(Update update, String fileName, String format) {
        return new SendAudio()
                .setChatId(update.getMessage().getChatId())
                .setAudio(getAudioFileByPath("/home/dvasylev/Music/" + fileName + "." + format));
    }

    @Override
    public String getBotUsername() {
        return super.getBotUsername();
    }

    @Override
    public String getBotToken() {
        return super.getBotToken();
    }

    @Override
    public void setBotUsername(String botUsername) {
        super.setBotUsername(botUsername);
    }

    @Override
    public void setBotToken(String botToken) {
        super.setBotToken(botToken);
    }
}

