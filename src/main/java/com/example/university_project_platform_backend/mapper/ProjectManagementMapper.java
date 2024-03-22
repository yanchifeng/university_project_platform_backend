package com.example.university_project_platform_backend.mapper;

import com.example.university_project_platform_backend.entity.ProjectManagement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.university_project_platform_backend.entity.StudentGroup;

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
    StudentGroup studentGroupSelect(Long groupId);

//    Map<String,Object> projectManagementSubmit(ProjectManagement projectManagement);
}
