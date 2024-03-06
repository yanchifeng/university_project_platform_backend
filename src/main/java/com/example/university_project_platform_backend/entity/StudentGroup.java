package com.example.university_project_platform_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("student_group")
public class StudentGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 小组id
     */
    @TableId(value = "group_id", type = IdType.AUTO)
    private Long groupId;

    /**
     * 小组队名
     */
    private String groupName;

    /**
     * 小组队长ID
     */
    private Long groupCaptainId;

    /**
     * 组员ID
     */
    private Long groupStudentId;

    /**
     * 小组创建时间
     */
    private LocalDateTime groupCreateTime;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getGroupCaptainId() {
        return groupCaptainId;
    }

    public void setGroupCaptainId(Long groupCaptainId) {
        this.groupCaptainId = groupCaptainId;
    }

    public Long getGroupStudentId() {
        return groupStudentId;
    }

    public void setGroupStudentId(Long groupStudentId) {
        this.groupStudentId = groupStudentId;
    }

    public LocalDateTime getGroupCreateTime() {
        return groupCreateTime;
    }

    public void setGroupCreateTime(LocalDateTime groupCreateTime) {
        this.groupCreateTime = groupCreateTime;
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
            "groupId = " + groupId +
            ", groupName = " + groupName +
            ", groupCaptainId = " + groupCaptainId +
            ", groupStudentId = " + groupStudentId +
            ", groupCreateTime = " + groupCreateTime +
        "}";
    }
}
