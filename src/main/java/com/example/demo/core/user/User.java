package com.example.demo.core.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@Table(name = "users")
public class User {
    @ToString.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "role")
    private String role;

    public User() { }

    public User(Long id) {
        this.id = id;
    }

    public User(String username, String role) {
       this.username = username;
       this.role = role;
    }
}
