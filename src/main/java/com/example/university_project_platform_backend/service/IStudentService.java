package com.example.university_project_platform_backend.service;

import com.example.university_project_platform_backend.entity.Student;
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
public interface IStudentService extends IService<Student> {
    boolean isStudentFormStudentID(String studentID);
    Map<String,Object> getStudentsFormStudentID(long studentID);

    boolean studentDelete(Long studentID);

    Map<String,Object> studentUpdate(Student student);

    Map<String, Object> getStudentTeacherByStudentId(Long studentId);
}
