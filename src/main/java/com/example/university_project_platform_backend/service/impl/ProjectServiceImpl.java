package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.university_project_platform_backend.entity.Project;
import com.example.university_project_platform_backend.entity.ProjectManagement;
import com.example.university_project_platform_backend.mapper.ProjectMapper;
import com.example.university_project_platform_backend.service.IProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

    @Override
    public Map<String, Object> projectUpdateByProjectCreator(Long ProjectCreatorId, Project project) {
        LambdaQueryWrapper<Project> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Project::getProjectCreator,ProjectCreatorId);
        wrapper.eq(Project::getProjectId,project.getProjectId());
        boolean projectFlag = this.update(project,wrapper);
        if (projectFlag){
            Project projectList = this.getOne(wrapper);
            Map<String,Object> projectMap = new HashMap<>();
            projectMap.put("data",projectList);
            return projectMap;
        }
        return null;
    }

    @Override
    public boolean projectDeleteByProjectCreator(Long mentorId, Long projectId) {
        return false;
    }
}
