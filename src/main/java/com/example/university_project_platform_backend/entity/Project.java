package com.example.university_project_platform_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-10
 */
@Getter
@Setter
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
     * 项目结束时间
     */
    private LocalDateTime projectEndTime;

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
    private Boolean projectTag;

    /**
     * 项目归属地
     */
    private String projectBelong;
}
