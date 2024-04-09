package com.example.university_project_platform_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("credits_operation")
public class CreditsOperation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 操作记录
     */
    @TableId(value = "credits_operation_id", type = IdType.AUTO)
    private Integer creditsOperationId;

    /**
     * 操作时间
     */
    private LocalDateTime creditsOperationTime;

    /**
     * 操作人员
     */
    private Long creditsOperationOperator;

    /**
     * 0:操作失败 1：操作成功 2：其他
     */
    private Boolean creditsOperationStatus;

    /**
     * 操作描述
     */
    private String creditsOperationDescription;

    /**
     * 学分记录
     */
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
