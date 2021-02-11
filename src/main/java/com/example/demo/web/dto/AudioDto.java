package com.example.demo.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AudioDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("author")
    private String author;
    @JsonProperty("file")
    private File file;

    public AudioDto() {

    }

    public AudioDto(String title, File file) {
        this.title = title;
        this.file = file;
    }

    public AudioDto(String title) {
        this.title = title;
    }

    public AudioDto(Long id, File file) {
        this.id = id;
        this.file = file;
    }

    public AudioDto(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public AudioDto(String author, String title, File file) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.file = file;
    }

    public AudioDto(Long id, String author, String title, File file) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.file = file;
    }
}
