package com.ucas.service.impl;

import com.ucas.mapper.UserMapper;
import com.ucas.pojo.dto.LoginRequest;
import com.ucas.pojo.dto.RegisterRequest;
import com.ucas.pojo.entity.User;
import com.ucas.pojo.vo.UserResponse;
import com.ucas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(RegisterRequest request) {
        // 检查用户名是否已存在
        User existingUser = userMapper.findByUsername(request.getUsername());
        if (existingUser != null) {
            throw new RuntimeException("用户名已存在");
        }

        // 创建新用户
        User user = new User();
        user.setUsername(request.getUsername());

        // 密码加密（使用 MD5 加密）
        String passwordDigest = DigestUtils.md5DigestAsHex(request.getPassword().getBytes());
        user.setPasswordDigest(passwordDigest);

        // 设置创建时间和更新时间
        Date now = new Date();
        user.setCreatedAt(now);
        user.setUpdatedAt(now);

        // 插入用户到数据库
        userMapper.insertUser(user);
    }

    @Override
    public UserResponse login(LoginRequest request) {
        // 根据用户名查询用户
        User user = userMapper.findByUsername(request.getUsername());
        if (user == null) {
            throw new RuntimeException("用户名不存在");
        }

        // 验证密码（密码加密后与数据库中的密码对比）
        String passwordDigest = DigestUtils.md5DigestAsHex(request.getPassword().getBytes());
        if (!user.getPasswordDigest().equals(passwordDigest)) {
            throw new RuntimeException("密码错误");
        }

        // 返回用户信息
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        return response;
    }

    @Override
    public void logout() {

    }

    @Override
    public UserResponse getCurrentUser() {
        return null;
    }
}