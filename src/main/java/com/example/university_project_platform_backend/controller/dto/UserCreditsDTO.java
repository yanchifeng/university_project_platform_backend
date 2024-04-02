package com.example.university_project_platform_backend.controller.dto;

import com.example.university_project_platform_backend.entity.Credits;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserCreditsDTO extends Credits {
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


}
