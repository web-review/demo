package com.example.demo.core.bot.impl;

import com.example.demo.core.AudioTelegramBotService;
import com.example.demo.core.bot.Audio;
import com.example.demo.core.repository.AudioRepository;
import com.example.demo.web.dto.AudioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AudioTelegramBotServiceImpl implements AudioTelegramBotService {
    @Autowired
    private AudioRepository audioRepository;
    ;

    public AudioTelegramBotServiceImpl() {
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AudioDto getAudioByTitle(AudioDto audioDto) {
        Audio audio = audioRepository.getAudioByTitle(audioDto.getTitle());
        return new AudioDto(audio.getId(), audio.getAuthor(), audio.getTitle(), audio.getFile());
    }

    public void saveAudio(AudioDto audioDto) throws RuntimeException {
        Audio audio = new Audio(audioDto.getId(),
                audioDto.getAuthor(),
                audioDto.getTitle(),
                audioDto.getFile());
        audioRepository.save(audio);
    }

    @Override
    public String getInfo() {
        return audioRepository.toString();
    }
}

