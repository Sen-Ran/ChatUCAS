package com.ucas.controller;

import com.ucas.pojo.dto.LoginRequest;
import com.ucas.pojo.dto.RegisterRequest;
import com.ucas.pojo.vo.UserResponse;
import com.ucas.result.Result; // 引入 Result
import com.ucas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // 注册接口
    @PostMapping("/register")
    public Result<String> register(@RequestBody RegisterRequest request) {
        try {
            userService.register(request);
            return Result.success("注册成功"); // 使用 Result.success
        } catch (Exception e) {
            return Result.error(e.getMessage()); // 使用 Result.error
        }
    }

    // 登录接口
    @PostMapping("/login/account")
    public Result<UserResponse> login(@RequestBody LoginRequest request) {
        try {
            UserResponse userResponse = userService.login(request);
            return Result.success(userResponse); // 使用 Result.success
        } catch (Exception e) {
            return Result.error(e.getMessage()); // 使用 Result.error
        }
    }
}