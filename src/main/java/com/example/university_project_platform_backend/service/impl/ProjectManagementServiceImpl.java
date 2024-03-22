package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.controller.dto.MentorProjectDTO;
import com.example.university_project_platform_backend.entity.Project;
import com.example.university_project_platform_backend.entity.ProjectManagement;
import com.example.university_project_platform_backend.entity.StudentGroup;
import com.example.university_project_platform_backend.mapper.ProjectManagementMapper;
import com.example.university_project_platform_backend.mapper.ProjectMapper;
import com.example.university_project_platform_backend.mapper.StudentMapper;
import com.example.university_project_platform_backend.service.IProjectManagementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.university_project_platform_backend.service.IProjectService;
import com.example.university_project_platform_backend.service.IStudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
@Service
public class ProjectManagementServiceImpl extends ServiceImpl<ProjectManagementMapper, ProjectManagement> implements IProjectManagementService {
    @Autowired
    IProjectService iProjectService;
    @Autowired
    IStudentGroupService iStudentGroupService;

    @Override
    public JsonResult projectManagementSubmitByProjectMentorDTO(MentorProjectDTO mentorProjectDTO) {
        //实例化学生组与项目管理
        StudentGroup studentGroup = new StudentGroup();
        ProjectManagement projectManagement = new ProjectManagement();
        //查询项目表有无冲突数据
        LambdaQueryWrapper<Project> projectWrapper = new LambdaQueryWrapper<>();
        projectWrapper.eq(Project::getProjectId, mentorProjectDTO.getProjectId());
        List<Project> projectList = iProjectService.list(projectWrapper);
        if (projectList.isEmpty()&&mentorProjectDTO.getCompetitionId()!=null) {
            boolean projectFlag = iProjectService.save(mentorProjectDTO);
            //验证存入数据情况
            if (projectFlag) {
                LambdaQueryWrapper<StudentGroup> studentGroupWrapper = new LambdaQueryWrapper<>();
                studentGroupWrapper.eq(StudentGroup::getGroupId, mentorProjectDTO.getGroupId());
                StudentGroup studentGroupList = iStudentGroupService.getOne(studentGroupWrapper);
                if (studentGroupList == null) {
                    //        新建学生组
                    studentGroup.setGroupId(mentorProjectDTO.getGroupId());
                    this.baseMapper.studentGroupInsertAuto(studentGroup);
                    System.out.println(studentGroup.getGroupId() + " and " + studentGroup.getGroupName());

                    projectManagement.setProjectId(mentorProjectDTO.getProjectId());
                    projectManagement.setCompetitionId(mentorProjectDTO.getCompetitionId());
                    projectManagement.setMentorId(mentorProjectDTO.getMentorId());
                    projectManagement.setGroupId(studentGroup.getGroupId());
                } else {
                    System.out.println("running:the studentGroupList != NULL");
                    if (studentGroupList.getGroupMentorId().equals(mentorProjectDTO.getMentorId())) {
                        projectManagement.setProjectId(mentorProjectDTO.getProjectId());
                        projectManagement.setCompetitionId(mentorProjectDTO.getCompetitionId());
                        projectManagement.setMentorId(mentorProjectDTO.getMentorId());
                        projectManagement.setGroupId(studentGroupList.getGroupId());
                    } else {
                        return JsonResult.ResultFail("学生组数据创建失败，已有数据冲突学生组,或该学生组数据不属于本教师");
                    }
                }
                boolean projectManagementFlag = this.save(projectManagement);
                if (projectManagementFlag) {
                    return JsonResult.ResultSuccess(mentorProjectDTO);
                } else {
                    return JsonResult.ResultFail("最终数据创建失败，已有项目管理组");
                }

            } else {
                return JsonResult.ResultFail("项目组数据创建失败，已有数据冲突项目组");
            }
        }else {
            return JsonResult.ResultFail("项目数据创建失败，已有数据冲突项目数据或缺少重要数据");
        }

    }
}
