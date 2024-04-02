package com.example.university_project_platform_backend.service;

import com.example.university_project_platform_backend.controller.dto.MentorProjectDTO;
import com.example.university_project_platform_backend.entity.ProjectManagementOperation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-01
 */
public interface IProjectManagementOperationService extends IService<ProjectManagementOperation> {

    boolean projectManagementOperationAdd(Long userId, MentorProjectDTO mentorProjectDTO, boolean b);
}
