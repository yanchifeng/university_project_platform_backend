package com.example.university_project_platform_backend.mapper;

import com.example.university_project_platform_backend.entity.Project;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
public interface ProjectMapper extends BaseMapper<Project> {
    List<Project> getStudentsProjectByStudentId(Long studentId);


    List<Project> getProjectWithStudentMentorData();
}
