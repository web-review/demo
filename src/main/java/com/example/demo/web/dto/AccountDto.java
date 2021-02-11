package com.example.demo.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.File;


@AllArgsConstructor
@Getter @Setter @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDto {
    @ToString.Exclude
    @JsonProperty("id")
    Long id;
    @ToString.Exclude
    @JsonProperty("name")
    String name;
    @JsonProperty("username")
    String username;
    @JsonProperty("content")
    String content;
    @JsonProperty("role")
    String role;
    @JsonProperty("avatar")
    File avatar;

    public AccountDto() { }

    public AccountDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
