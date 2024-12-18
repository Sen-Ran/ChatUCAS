package com.ucas.mapper;

import com.ucas.pojo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    // 插入用户
    @Insert("INSERT INTO users (username, password_digest, created_at, updated_at) " +
            "VALUES (#{username}, #{passwordDigest}, #{createdAt}, #{updatedAt})")
    void insertUser(User user);

    // 根据用户名查询用户
    @Select("SELECT * FROM users WHERE username = #{username}")
    User findByUsername(String username);
}