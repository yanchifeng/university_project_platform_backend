package com.example.university_project_platform_backend.service;

import com.example.university_project_platform_backend.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
public interface IUserService extends IService<User> {
    Map<String, Object> login(User user);

    Map<String, Object> info(String token);

    Map<String, Object> register(User user);
}
