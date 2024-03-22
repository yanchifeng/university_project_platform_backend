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
 * @since 2024-03-22
 */
@Getter
@Setter
public class Competition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Competition_id", type = IdType.AUTO)
    private Long competitionId;

    private String competitionName;

    private String competitionFrom;
}
