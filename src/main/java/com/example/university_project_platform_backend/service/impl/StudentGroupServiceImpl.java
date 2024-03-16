package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.university_project_platform_backend.entity.Student;
import com.example.university_project_platform_backend.entity.StudentGroup;
import com.example.university_project_platform_backend.mapper.StudentGroupMapper;
import com.example.university_project_platform_backend.service.IStudentGroupService;
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
public class StudentGroupServiceImpl extends ServiceImpl<StudentGroupMapper, StudentGroup> implements IStudentGroupService {

    @Override
    public Map<String, Object> studentGroupUpdate(StudentGroup studentGroup) {
        LambdaQueryWrapper<StudentGroup> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudentGroup::getGroupId,studentGroup.getGroupId());
        boolean studentFlag = this.update(studentGroup,wrapper);
        if (studentFlag){
            StudentGroup studentGroupList = this.getOne(wrapper);
            Map<String,Object> studentMap = new HashMap<>();
            studentMap.put("data",studentGroupList);
            return studentMap;
        }
        return null;
    }

    @Override
    public Map<String, Object> getStudentGroupsFormStudentID(long studentGroupId) {
        Map<String,Object> studentMap = new HashMap<>();
        LambdaQueryWrapper<StudentGroup> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudentGroup::getGroupId,studentGroupId);
        System.out.println(studentGroupId);
        List<StudentGroup> searchStudentList = this.list(wrapper);
        studentMap.put("data",searchStudentList);
        return studentMap;
    }

    @Override
    public boolean studentGroupDelete(Long studentGroupId) {
        LambdaQueryWrapper<StudentGroup> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudentGroup::getGroupId, studentGroupId);
        int studentFlag = this.baseMapper.delete(wrapper);
        if (studentFlag!=0){
            return true;
        }else {
            return false;
        }
    }
}
