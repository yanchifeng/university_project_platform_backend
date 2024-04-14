package com.example.university_project_platform_backend.mapper;

import com.example.university_project_platform_backend.entity.Mentor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.university_project_platform_backend.entity.Project;
import com.example.university_project_platform_backend.entity.Student;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
public interface MentorMapper extends BaseMapper<Mentor> {

    List<Student> getStudentTeacherByStudentId(Long mentorId);
}
