package com.example.university_project_platform_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
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

    public Long getMentorId() {
        return mentorId;
    }

    public void setMentorId(Long mentorId) {
        this.mentorId = mentorId;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public Boolean getMentorProfessionalId() {
        return mentorProfessionalId;
    }

    public void setMentorProfessionalId(Boolean mentorProfessionalId) {
        this.mentorProfessionalId = mentorProfessionalId;
    }

    public Boolean getMentorSex() {
        return mentorSex;
    }

    public void setMentorSex(Boolean mentorSex) {
        this.mentorSex = mentorSex;
    }

    public String getMentorPhoneNumber() {
        return mentorPhoneNumber;
    }

    public void setMentorPhoneNumber(String mentorPhoneNumber) {
        this.mentorPhoneNumber = mentorPhoneNumber;
    }

    public String getMentorEmail() {
        return mentorEmail;
    }

    public void setMentorEmail(String mentorEmail) {
        this.mentorEmail = mentorEmail;
    }

    @Override
    public String toString() {
        return "Mentor{" +
            "mentorId = " + mentorId +
            ", mentorName = " + mentorName +
            ", mentorProfessionalId = " + mentorProfessionalId +
            ", mentorSex = " + mentorSex +
            ", mentorPhoneNumber = " + mentorPhoneNumber +
            ", mentorEmail = " + mentorEmail +
        "}";
    }
}
