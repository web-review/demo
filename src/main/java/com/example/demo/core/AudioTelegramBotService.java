package com.example.demo.core;

import com.example.demo.web.dto.AudioDto;

public interface AudioTelegramBotService {
    AudioDto getAudioByTitle(AudioDto audioDto);
    public String getInfo();
}

