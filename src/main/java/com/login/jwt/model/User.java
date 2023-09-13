package com.login.jwt.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")

    private Integer id;
    private String name;
    private String email;
    private String password;
}
