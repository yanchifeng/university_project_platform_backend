package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.university_project_platform_backend.entity.Credits;
import com.example.university_project_platform_backend.entity.Mentor;
import com.example.university_project_platform_backend.entity.Student;
import com.example.university_project_platform_backend.mapper.CreditsMapper;
import com.example.university_project_platform_backend.service.ICreditsService;
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
 * @since 2024-03-30
 */
@Service
public class CreditsServiceImpl extends ServiceImpl<CreditsMapper, Credits> implements ICreditsService {

    @Override
    public Map<String, Object> getCreditsByStudentId(long studentId) {
        Map<String,Object> creditsMap = new HashMap<>();
        LambdaQueryWrapper<Credits> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Credits::getStudentId,studentId);
        System.out.println(studentId);
        List<Credits> searchCreditsList = this.list(wrapper);
        creditsMap.put("data",searchCreditsList);
        return creditsMap;
    }
}
