package com.example.university_project_platform_backend.service;

import com.example.university_project_platform_backend.entity.Project;
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
public interface IProjectService extends IService<Project> {

    Map<String, Object> projectUpdateByProjectCreator(Long ProjectCreatorId, Project project);

    boolean projectDeleteByProjectCreator(Long mentorId, Long projectId);
}
