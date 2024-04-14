package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.university_project_platform_backend.entity.Mentor;
import com.example.university_project_platform_backend.entity.Mentor;
import com.example.university_project_platform_backend.entity.Project;
import com.example.university_project_platform_backend.entity.Student;
import com.example.university_project_platform_backend.mapper.MentorMapper;
import com.example.university_project_platform_backend.service.IMentorService;
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
public class MentorServiceImpl extends ServiceImpl<MentorMapper, Mentor> implements IMentorService {

    @Override
    public boolean isMentorFromMentorID(String mentorID) {
        LambdaQueryWrapper<Mentor> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Mentor::getMentorId,mentorID);
        System.out.println(mentorID);
        List<Mentor> searchMentorList = this.list(wrapper);
        System.out.println(searchMentorList==null);
        if (searchMentorList.size() == 0){
            return false;
        }else {
            System.out.println(searchMentorList);
            return true;
        }
    }

    @Override
    public Map<String, Object> getMentorsFormMentorID(long mentorID) {
        Map<String,Object> mentorMap = new HashMap<>();
        LambdaQueryWrapper<Mentor> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Mentor::getMentorId,mentorID);
        System.out.println(mentorID);
        List<Mentor> searchMentorList = this.list(wrapper);
        mentorMap.put("data",searchMentorList);
        return mentorMap;
    }

    @Override
    public boolean mentorDelete(long mentorID) {
        LambdaQueryWrapper<Mentor> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Mentor::getMentorId, mentorID);
        int mentorFlag = this.baseMapper.delete(wrapper);
        if (mentorFlag!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Map<String, Object> mentorUpdate(Mentor mentor) {
        LambdaQueryWrapper<Mentor> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Mentor::getMentorId,mentor.getMentorId());
        boolean mentorFlag = this.update(mentor,wrapper);
        if (mentorFlag){
            Mentor mentorList = this.getOne(wrapper);
            Map<String,Object> mentorMap = new HashMap<>();
            mentorMap.put("data",mentorList);
            return mentorMap;
        }
        return null;
    }

    @Override
    public Map<String, Object> getStudentTeacherByStudentId(Long mentorId) {
        Map<String, Object> studentMap = new HashMap<>();
        List<Student> projectList = this.baseMapper.getStudentTeacherByStudentId(mentorId);
        studentMap.put("data", projectList);
        return studentMap;
    }

}
