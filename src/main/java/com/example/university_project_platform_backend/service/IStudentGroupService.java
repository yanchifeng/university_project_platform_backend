package com.example.university_project_platform_backend.service;

import com.example.university_project_platform_backend.entity.StudentGroup;
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
public interface IStudentGroupService extends IService<StudentGroup> {

    Map<String, Object> studentGroupUpdate(StudentGroup studentGroup);

    Map<String, Object> getStudentGroupsFormStudentID(long studentGroupId);

    boolean studentGroupDelete(Long studentGroupId);
}
