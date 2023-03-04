package com.walatech.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    @Column(name = "namalengkap", nullable = false,length = 100)
    private String namalengkap;

    @Column(name = "username", nullable = false,length = 100)
    private String username;

    @Column(name = "password", nullable = false,length = 100)
    private String password;

    @Column(name = "status", nullable = false,length = 1)
    private String status;
}
