package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.university_project_platform_backend.entity.Project;
import com.example.university_project_platform_backend.entity.ProjectManagement;
import com.example.university_project_platform_backend.entity.StudentGroup;
import com.example.university_project_platform_backend.mapper.ProjectMapper;
import com.example.university_project_platform_backend.service.IProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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

    @Override
    public Map<String, Object> projectSearchByProject(Project project) {
        Map<String,Object> projectMap = new HashMap<>();
        LambdaQueryWrapper<Project> wrapper = new LambdaQueryWrapper<>();
        wrapper.or(i -> i
                .eq(Project::getProjectId,project.getProjectId())
                .eq(Project::getProjectName,project.getProjectName())
                .eq(Project::getProjectCreator,project.getProjectCreator())
                .eq(Project::getProjectScope,project.getProjectScope())
                .eq(Project::getProjectTag,project.getProjectTag())
                .eq(Project::getProjectBelong,project.getProjectBelong())
//                .eq(Project::getProjectProposalLink,project.getProjectProposalLink())
//                .eq(Project::getProjectEndTime,project.getProjectEndTime())
//                .eq(Project::getProjectCreateTime,project.getProjectCreateTime())
//                .eq(Project::getProjectIntroduction,project.getProjectIntroduction())
        );

        List<Project> projectList = this.list(wrapper);
        if (!projectList.isEmpty()){
            System.out.println("success");
            projectMap.put("data",projectList);
            return projectMap;
        }else {
            return null;
        }
    }

    @Override
    public Map<String, Object> getProjectNew() {
        Map<String,Object> projectMap = new HashMap<>();
        LambdaQueryWrapper<Project> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Project::getProjectCreateTime).last("LIMIT 15");
        List<Project> top15Projects = this.baseMapper.selectList(wrapper);
        if (!top15Projects.isEmpty()){
            projectMap.put("data",top15Projects);
        }else {
            return null;
        }
        return projectMap;
    }

    @Override
    public Map<String, Object> getStudentsProjectByStudentId(Long studentId) {

        Map<String, Object> studentMap = new HashMap<>();
        List<Project> projectList = this.baseMapper.getStudentsProjectByStudentId(studentId);
        studentMap.put("data", projectList);
        return studentMap;
    }

    @Override
    public Map<String, Object> getProjectWithStudentMentorData() {
        Map<String, Object> projectMap = new HashMap<>();
        List<Project> projectList = this.baseMapper.getProjectWithStudentMentorData();
        projectMap.put("data",projectList);
        return projectMap;
    }

}
