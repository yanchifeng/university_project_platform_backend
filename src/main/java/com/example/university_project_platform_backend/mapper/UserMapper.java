package com.example.university_project_platform_backend.mapper;

import com.example.university_project_platform_backend.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
public interface UserMapper extends BaseMapper<User> {
    public List<String> getMentorByName(String mentorName);
    public List<String> getStudentByName(String mentorName);
}
