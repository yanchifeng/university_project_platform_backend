package com.example.university_project_platform_backend.service;

import com.example.university_project_platform_backend.entity.Mentor;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.university_project_platform_backend.entity.Student;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
public interface IMentorService extends IService<Mentor> {
    boolean isMentorFromMentorID(String mentorID);
    Map<String,Object> getMentorsFormMentorID(long mentorID);

    boolean mentorDelete(long mentorID);

    Map<String,Object> mentorUpdate(Mentor mentor);

    Map<String, Object> getStudentTeacherByStudentId(Long mentorId);
}
