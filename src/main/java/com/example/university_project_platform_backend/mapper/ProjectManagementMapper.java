package com.example.university_project_platform_backend.mapper;

import com.example.university_project_platform_backend.controller.dto.MentorProjectDTO;
import com.example.university_project_platform_backend.entity.ProjectManagement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.university_project_platform_backend.entity.StudentGroup;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
public interface ProjectManagementMapper extends BaseMapper<ProjectManagement> {
    long studentGroupInsertAuto(StudentGroup studentGroup);
    boolean studentGroupInsert(StudentGroup studentGroup);
    List<MentorProjectDTO> projectManagementSelectByCompetitionId(MentorProjectDTO mentorProjectDTO);

//    Map<String,Object> projectManagementSubmit(ProjectManagement projectManagement);
}
