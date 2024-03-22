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
 * @since 2024-03-22
 */
@Getter
@Setter
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学生id
     */
    @TableId(value = "student_id", type = IdType.AUTO)
    private Long studentId;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 学生性别(男1 女2)
     */
    private Boolean studentSex;

    /**
     * 入学年份
     */
    private LocalDateTime studentAdmissionTime;

    /**
     * 学生年龄
     */
    private Integer studentAge;

    /**
     * 手机号码
     */
    private String studentPhoneNumber;

    /**
     * 学生邮箱(固定格式:xxx@graduation)
     */
    private String studentEmail;

    /**
     * 学生班级
     */
    private String studentClass;
}
