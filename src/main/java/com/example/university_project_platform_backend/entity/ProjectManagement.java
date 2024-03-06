package com.example.university_project_platform_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
@TableName("project_management")
public class ProjectManagement implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "project_management_id", type = IdType.AUTO)
    private Integer projectManagementId;

    /**
     * 项目编号
     */
    private Long projectId;

    /**
     * 导师编号
     */
    private Long mentorId;

    /**
     * 小组编号
     */
    private Long groupId;

    /**
     * 项目状态id 0代表未通过 1代表通过 2代表审核中 
     */
    private Boolean projectStatusId;

    /**
     * 项目状态状态描述 注释/备注
     */
    private String projectStatusDescription;

    public Integer getProjectManagementId() {
        return projectManagementId;
    }

    public void setProjectManagementId(Integer projectManagementId) {
        this.projectManagementId = projectManagementId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getMentorId() {
        return mentorId;
    }

    public void setMentorId(Long mentorId) {
        this.mentorId = mentorId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Boolean getProjectStatusId() {
        return projectStatusId;
    }

    public void setProjectStatusId(Boolean projectStatusId) {
        this.projectStatusId = projectStatusId;
    }

    public String getProjectStatusDescription() {
        return projectStatusDescription;
    }

    public void setProjectStatusDescription(String projectStatusDescription) {
        this.projectStatusDescription = projectStatusDescription;
    }

    @Override
    public String toString() {
        return "ProjectManagement{" +
            "projectManagementId = " + projectManagementId +
            ", projectId = " + projectId +
            ", mentorId = " + mentorId +
            ", groupId = " + groupId +
            ", projectStatusId = " + projectStatusId +
            ", projectStatusDescription = " + projectStatusDescription +
        "}";
    }
}
