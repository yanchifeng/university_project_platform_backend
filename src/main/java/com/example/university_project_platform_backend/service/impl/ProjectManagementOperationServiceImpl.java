package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.university_project_platform_backend.controller.dto.MentorProjectDTO;
import com.example.university_project_platform_backend.entity.ProjectManagement;
import com.example.university_project_platform_backend.entity.ProjectManagementOperation;
import com.example.university_project_platform_backend.mapper.ProjectManagementOperationMapper;
import com.example.university_project_platform_backend.service.IProjectManagementOperationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.university_project_platform_backend.service.IProjectManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-01
 */
@Service
public class ProjectManagementOperationServiceImpl extends ServiceImpl<ProjectManagementOperationMapper, ProjectManagementOperation> implements IProjectManagementOperationService {
    @Autowired
    IProjectManagementService   iProjectManagementService;
    @Override
    public boolean projectManagementOperationAdd(Long userId, MentorProjectDTO mentorProjectDTO, boolean isSuccess) {

        LambdaQueryWrapper<ProjectManagement> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProjectManagement::getProjectId,mentorProjectDTO.getProjectId());
        wrapper.eq(ProjectManagement::getMentorId,mentorProjectDTO.getMentorId());
        wrapper.eq(ProjectManagement::getCompetitionId,mentorProjectDTO.getCompetitionId());
        ProjectManagement projectManagement = iProjectManagementService.getOne(wrapper);
        ProjectManagementOperation projectManagementOperation =  new ProjectManagementOperation(userId,projectManagement,isSuccess);
        return this.save(projectManagementOperation);
    }
}
