package com.example.university_project_platform_backend.mapper;

import com.example.university_project_platform_backend.entity.Project;
import com.example.university_project_platform_backend.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
public interface StudentMapper extends BaseMapper<Student> {
    List<Student> getStudentTeacherByStudentId(Long studentId);
}
