package com.example.university_project_platform_backend.service;

import com.example.university_project_platform_backend.controller.dto.UserCreditsDTO;
import com.example.university_project_platform_backend.entity.Credits;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.university_project_platform_backend.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-30
 */
public interface ICreditsService extends IService<Credits> {



    Map<String,Object> getCreditsByStudentId(long studentId);

    boolean creditsAdd(long userId, UserCreditsDTO credits);
}
