package com.example.university_project_platform_backend.controller.dto;

import com.example.university_project_platform_backend.entity.ProjectManagement;
import com.example.university_project_platform_backend.entity.ProjectManagementOperation;

public class OperationProjectManagementDTO extends ProjectManagementOperation {

    public OperationProjectManagementDTO(long operator, ProjectManagement projectManagement, boolean isSuccess, String operationDescription) {
        super.setProjectManagementOperationOperator(operator);
        super.setProjectManagementOperationStatus(isSuccess);
        super.setProjectManagementOperationDescription(operationDescription);
//        super.getProjectManagementOperationTime()
        // 假设MentorProjectDTO有相应的属性映射
        super.setProjectManagementId(projectManagement.getProjectManagementId());
        super.setProjectId(projectManagement.getProjectId());
        super.setMentorId(projectManagement.getMentorId());
        super.setCompetitionId(projectManagement.getCompetitionId());
        super.setGroupId(projectManagement.getGroupId());
        super.setProjectStatusId(projectManagement.getProjectStatusId());
        super.setProjectStatusDescription(projectManagement.getProjectStatusDescription());



//
//        this.projectManagementOperationOperator = operator;
//        this.projectManagementOperationStatus = status;
//        this.projectManagementOperationDescription = operationDescription;
//        this.projectManagementOperationTime = operationTime == null ? LocalDateTime.now() : operationTime;

//        this.projectManagementId = projectManagement.getProjectManagementId();
//        this.projectId = projectManagement.getProjectId();
//        this.mentorId = projectManagement.getMentorId();
//        this.competitionId = projectManagement.getCompetitionId();
//        this.groupId = projectManagement.getGroupId();
//        this.projectStatusId = projectManagement.getProjectStatusId();
//        this.projectStatusDescription = projectManagement.getProjectStatusDescription();

        // 注意：projectManagementOperationId 属性可能是自动生成的，所以在这里不设置
    }
}
