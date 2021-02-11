package com.example.demo.core.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter
@AllArgsConstructor @ToString
@Table(name = "users")
public class User {
    @ToString.Exclude
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Long id;
    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", updatable = false, nullable = false)
    Profile profile;
    @ToString.Exclude
    @Column(name = "role")
    String role;
    @Column(name = "username")
    String username;

    public User() { }
}
