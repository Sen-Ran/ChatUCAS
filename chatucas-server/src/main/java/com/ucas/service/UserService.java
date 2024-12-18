package com.ucas.service;

import com.ucas.pojo.dto.LoginRequest;
import com.ucas.pojo.dto.RegisterRequest;
import com.ucas.pojo.vo.UserResponse;

public interface UserService {
    void register(RegisterRequest request);
    UserResponse login(LoginRequest request);
    void logout();
    UserResponse getCurrentUser();
}