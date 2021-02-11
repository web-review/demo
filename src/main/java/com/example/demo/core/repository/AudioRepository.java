package com.example.demo.core.repository;

import com.example.demo.core.bot.Audio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioRepository extends JpaRepository<Audio, Long> {
    Audio getAudioByTitle(String title);
}
