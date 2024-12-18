package com.ucas.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private String passwordDigest;
    private Date createdAt;
    private Date updatedAt;
}