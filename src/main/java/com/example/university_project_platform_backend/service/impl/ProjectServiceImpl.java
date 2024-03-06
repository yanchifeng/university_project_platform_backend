package com.example.university_project_platform_backend.service.impl;

import com.example.university_project_platform_backend.entity.Project;
import com.example.university_project_platform_backend.mapper.ProjectMapper;
import com.example.university_project_platform_backend.service.IProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

}
