package com.example.university_project_platform_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Mentor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 导师ID
     */
    @TableId(value = "mentor_id", type = IdType.AUTO)
    private Long mentorId;

    /**
     * 导师姓名
     */
    private String mentorName;

    /**
     * 导师职称(辅导员1 教师2 系副主任3 系主任4 副院长5 院长6)
     */
    private Boolean mentorProfessionalId;

    /**
     * 导师性别(男1 女2)
     */
    private Boolean mentorSex;

    /**
     * 导师手机号码
     */
    private String mentorPhoneNumber;

    /**
     * 导师邮箱(固定格式:xxx@graduation)
     */
    private String mentorEmail;
}
