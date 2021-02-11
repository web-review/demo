package com.example.demo.core.bot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.File;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "audios")
public class Audio {
    @Id
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "file")
    private File file;

    public Audio() {
    }
}
