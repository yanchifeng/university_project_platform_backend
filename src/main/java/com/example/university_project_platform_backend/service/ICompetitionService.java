package com.example.university_project_platform_backend.service;

import com.example.university_project_platform_backend.controller.dto.MentorProjectDTO;
import com.example.university_project_platform_backend.entity.Competition;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-16
 */
public interface ICompetitionService extends IService<Competition> {

    Map<String, Object> projectManagementSubmitByMentorProjectDTO(MentorProjectDTO mentorProjectDTO);

}
