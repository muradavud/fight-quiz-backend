package com.muradavud.ufcquiz.ufcquiz.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, unique = true)
    private String userName;
    private String password;
    private boolean active;
    private String roles;

}
