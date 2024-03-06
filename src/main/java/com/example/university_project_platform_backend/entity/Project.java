package com.example.university_project_platform_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目id
     */
    @TableId(value = "project_id", type = IdType.AUTO)
    private Long projectId;

    /**
     * 项目姓名
     */
    private String projectName;

    /**
     * 项目简介
     */
    private String projectIntroduction;

    /**
     * 项目创建时间
     */
    private LocalDateTime projectCreateTime;

    /**
     * 项目连接
     */
    private String projectProposalLink;

    /**
     * 创建者ID
     */
    private Long projectCreator;

    /**
     * 项目范围
     */
    private String projectScope;

    /**
     * 项目标签
     */
    private String projectTag;

    /**
     * 项目归属地
     */
    private String projectBelong;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIntroduction() {
        return projectIntroduction;
    }

    public void setProjectIntroduction(String projectIntroduction) {
        this.projectIntroduction = projectIntroduction;
    }

    public LocalDateTime getProjectCreateTime() {
        return projectCreateTime;
    }

    public void setProjectCreateTime(LocalDateTime projectCreateTime) {
        this.projectCreateTime = projectCreateTime;
    }

    public String getProjectProposalLink() {
        return projectProposalLink;
    }

    public void setProjectProposalLink(String projectProposalLink) {
        this.projectProposalLink = projectProposalLink;
    }

    public Long getProjectCreator() {
        return projectCreator;
    }

    public void setProjectCreator(Long projectCreator) {
        this.projectCreator = projectCreator;
    }

    public String getProjectScope() {
        return projectScope;
    }

    public void setProjectScope(String projectScope) {
        this.projectScope = projectScope;
    }

    public String getProjectTag() {
        return projectTag;
    }

    public void setProjectTag(String projectTag) {
        this.projectTag = projectTag;
    }

    public String getProjectBelong() {
        return projectBelong;
    }

    public void setProjectBelong(String projectBelong) {
        this.projectBelong = projectBelong;
    }

    @Override
    public String toString() {
        return "Project{" +
            "projectId = " + projectId +
            ", projectName = " + projectName +
            ", projectIntroduction = " + projectIntroduction +
            ", projectCreateTime = " + projectCreateTime +
            ", projectProposalLink = " + projectProposalLink +
            ", projectCreator = " + projectCreator +
            ", projectScope = " + projectScope +
            ", projectTag = " + projectTag +
            ", projectBelong = " + projectBelong +
        "}";
    }
}
