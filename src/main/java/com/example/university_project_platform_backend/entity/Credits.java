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
 * @since 2024-04-02
 */
@Getter
@Setter
public class Credits implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学分记录
     */
    @TableId(value = "credits_id", type = IdType.AUTO)
    private Long creditsId;

    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 学分
     */
    private Integer creditsValue;

    /**
     * 学分描述
     */
    private String creditsDescription;
}
