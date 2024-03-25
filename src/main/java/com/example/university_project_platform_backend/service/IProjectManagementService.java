package com.example.university_project_platform_backend.service;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.controller.dto.MentorProjectDTO;
import com.example.university_project_platform_backend.entity.ProjectManagement;
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
public interface IProjectManagementService extends IService<ProjectManagement> {

    JsonResult projectManagementSubmitByProjectMentorDTO(MentorProjectDTO mentorProjectDTO);

    Map<String, Object> projectManagementSelectByProjectMentorDTO(MentorProjectDTO mentorProjectDTO);

    Map<String, Object> projectManagementUpdateByProjectMentorDTO(MentorProjectDTO mentorProjectDTO);

    Map<String, Object> projectManagementReview(Long competitionId,ProjectManagement projectManagement);
}
