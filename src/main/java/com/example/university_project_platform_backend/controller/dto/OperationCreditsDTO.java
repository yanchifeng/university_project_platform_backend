package com.example.university_project_platform_backend.controller.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.university_project_platform_backend.entity.Credits;
import com.example.university_project_platform_backend.entity.CreditsOperation;

import java.time.LocalDateTime;

public class OperationCreditsDTO extends CreditsOperation {

    public OperationCreditsDTO(long operationOperator, UserCreditsDTO credits,boolean operationStatus,String operationDescription) {
        super.setCreditsOperationDescription(operationDescription);
        super.setCreditsOperationOperator(operationOperator);
        super.setCreditsOperationStatus(operationStatus);
        super.setCreditsId(credits.getCreditsId());
        super.setStudentId(credits.getStudentId());
        super.setCreditsValue(credits.getCreditsValue());
        super.setCreditsDescription(credits.getCreditsDescription());
    }
}
