package com.example.university_project_platform_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
     * 竞赛处id
     */
    private Long competitionId;

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
}
