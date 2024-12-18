package com.ucas.pojo.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}