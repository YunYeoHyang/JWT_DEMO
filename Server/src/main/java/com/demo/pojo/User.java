package com.demo.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author JeungNyeongJae
 * @date 2019/12/2
 */

@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
