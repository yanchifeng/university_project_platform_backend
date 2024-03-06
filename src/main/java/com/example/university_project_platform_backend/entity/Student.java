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

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Boolean getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(Boolean studentSex) {
        this.studentSex = studentSex;
    }

    public LocalDateTime getStudentAdmissionTime() {
        return studentAdmissionTime;
    }

    public void setStudentAdmissionTime(LocalDateTime studentAdmissionTime) {
        this.studentAdmissionTime = studentAdmissionTime;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(String studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    @Override
    public String toString() {
        return "Student{" +
            "studentId = " + studentId +
            ", studentName = " + studentName +
            ", studentSex = " + studentSex +
            ", studentAdmissionTime = " + studentAdmissionTime +
            ", studentAge = " + studentAge +
            ", studentPhoneNumber = " + studentPhoneNumber +
            ", studentEmail = " + studentEmail +
            ", studentClass = " + studentClass +
        "}";
    }
}
