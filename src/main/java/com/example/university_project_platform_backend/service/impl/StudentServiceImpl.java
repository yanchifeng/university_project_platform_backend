package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.university_project_platform_backend.entity.Student;
import com.example.university_project_platform_backend.mapper.StudentMapper;
import com.example.university_project_platform_backend.service.IStudentService;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Override
    public boolean isStudentFormStudentID(String studentID) {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Student::getStudentId, studentID);
        System.out.println(studentID);
        List<Student> searchStudentList = this.list(wrapper);
        if (searchStudentList.size() == 0) {
            return false;
        } else {
            System.out.println(searchStudentList);
            return true;
        }
    }

    @Override
    public Map<String, Object> getStudentsFormStudentID(long studentID) {
        Map<String,Object> studentMap = new HashMap<>();
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Student::getStudentId,studentID);
        System.out.println(studentID);
        List<Student> searchStudentList = this.list(wrapper);
        studentMap.put("data",searchStudentList);
        return studentMap;
    }

    @Override
    public boolean studentDelete(Long studentID) {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Student::getStudentId, studentID);
        int studentFlag = this.baseMapper.delete(wrapper);
        if (studentFlag!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Map<String, Object> studentUpdate(Student student) {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Student::getStudentId,student.getStudentId());
        boolean studentFlag = this.update(student,wrapper);
        if (studentFlag){
            Student studentList = this.getOne(wrapper);
            Map<String,Object> studentMap = new HashMap<>();
            studentMap.put("data",studentList);
            return studentMap;
        }
        return null;
    }
}
