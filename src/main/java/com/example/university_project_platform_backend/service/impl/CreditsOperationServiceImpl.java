package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.university_project_platform_backend.controller.dto.UserCreditsDTO;
import com.example.university_project_platform_backend.entity.CreditsOperation;
import com.example.university_project_platform_backend.mapper.CreditsOperationMapper;
import com.example.university_project_platform_backend.service.ICreditsOperationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-01
 */
@Service
public class CreditsOperationServiceImpl extends ServiceImpl<CreditsOperationMapper, CreditsOperation> implements ICreditsOperationService {

    @Override
    public boolean creditsOperationAdd(long userId,UserCreditsDTO credits,boolean status) {
        CreditsOperation creditsOperation = new CreditsOperation(userId,status,credits);
        return this.save(creditsOperation);
    }
}
