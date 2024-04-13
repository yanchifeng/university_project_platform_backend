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

    Map<String, Object> projectManagementSubmitByProjectMentorDTO(MentorProjectDTO mentorProjectDTO);

    Map<String, Object> projectManagementSelectByMentorProjectDTO(MentorProjectDTO mentorProjectDTO);

    Map<String, Object> projectManagementUpdateByMentorId(Long mentorId,ProjectManagement projectManagement);

    Map<String, Object> projectManagementReview(Long competitionId,ProjectManagement projectManagement);

    boolean projectManagementDeleteByMentorId(Long mentorId, Long projectId);



    Map<String, Object> projectManagementSearchByMentorProjectDTO(ProjectManagement projectManagement);
}
