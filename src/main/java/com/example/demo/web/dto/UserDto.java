package com.example.demo.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    @ToString.Exclude
    Long id;
    @JsonProperty("username")
    String username;
    @JsonProperty("role")
    String role;

    public UserDto() {
    }

    public UserDto(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public UserDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}