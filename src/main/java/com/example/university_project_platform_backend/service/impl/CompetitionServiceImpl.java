package com.example.university_project_platform_backend.service.impl;

import com.example.university_project_platform_backend.controller.dto.MentorProjectDTO;
import com.example.university_project_platform_backend.entity.Competition;
import com.example.university_project_platform_backend.entity.Project;
import com.example.university_project_platform_backend.mapper.CompetitionMapper;
import com.example.university_project_platform_backend.service.ICompetitionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-16
 */
@Service
public class CompetitionServiceImpl extends ServiceImpl<CompetitionMapper, Competition> implements ICompetitionService {

    @Override
    public Map<String, Object> projectManagementSubmitByMentorProjectDTO(MentorProjectDTO mentorProjectDTO) {

        return null;
    }
}
