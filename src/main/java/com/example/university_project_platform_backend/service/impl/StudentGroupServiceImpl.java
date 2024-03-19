package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.university_project_platform_backend.entity.Mentor;
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
        boolean studentGroupFlag = this.update(studentGroup,wrapper);
        if (studentGroupFlag){
            StudentGroup studentGroupList = this.getOne(wrapper);
            Map<String,Object> studentGroupMap = new HashMap<>();
            studentGroupMap.put("data",studentGroupList);
            return studentGroupMap;
        }
        return null;
    }

    @Override
    public Map<String, Object> getStudentGroupsFormStudentID(long studentGroupId) {
        Map<String,Object> studentGroupMap = new HashMap<>();
        LambdaQueryWrapper<StudentGroup> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudentGroup::getGroupId,studentGroupId);
        System.out.println(studentGroupId);
        List<StudentGroup> searchStudentList = this.list(wrapper);
        studentGroupMap.put("data",searchStudentList);
        return studentGroupMap;
    }

    @Override
    public boolean studentGroupDelete(Long studentGroupId) {
        LambdaQueryWrapper<StudentGroup> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudentGroup::getGroupId, studentGroupId);
        int studentGroupFlag = this.baseMapper.delete(wrapper);
        if (studentGroupFlag!=0){
            return true;
        }else {
            return false;
        }
    }




    @Override
    public Map<String, Object> studentGroupShowByMentorId(Long mentorId) {
        Map<String,Object> studentGroupMap = new HashMap<>();
        LambdaQueryWrapper<StudentGroup> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudentGroup::getGroupMentorId,mentorId);
        List<StudentGroup> studentGroupList = this.list(wrapper);
        if (studentGroupList!=null){
            System.out.println("success");
            studentGroupMap.put("data",studentGroupList);
            return studentGroupMap;
        }else {
            return null;
        }
    }

    @Override
    public boolean studentGroupDeleteByMentorId(Long groupMentorId, Long groupId) {
        LambdaQueryWrapper<StudentGroup> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudentGroup::getGroupId, groupId);
        wrapper.eq(StudentGroup::getGroupMentorId, groupMentorId);
        int mentorFlag = this.baseMapper.delete(wrapper);
        if (mentorFlag!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Map<String, Object> studentGroupUpdateByMentorId(Long groupMentorId, StudentGroup studentGroup) {
        LambdaQueryWrapper<StudentGroup> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudentGroup::getGroupId,studentGroup.getGroupId());
        wrapper.eq(StudentGroup::getGroupMentorId,groupMentorId);
        boolean studentGroupFlag = this.update(studentGroup,wrapper);
        if (studentGroupFlag){
            StudentGroup studentGroupList = this.getOne(wrapper);
            Map<String,Object> studentGroupMap = new HashMap<>();
            studentGroupMap.put("data",studentGroupList);
            return studentGroupMap;
        }
        return null;
    }

}
