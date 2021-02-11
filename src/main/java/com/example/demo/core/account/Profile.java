package com.example.demo.core.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@Getter @Setter @ToString
@Table(name = "profiles")
public class Profile implements Serializable {
    @ToString.Exclude
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "username")
    private String username;
    @Column(name = "content")
    private String content;
    @Column(name = "avatar")
    private File avatar;

    public Profile() { }
}
