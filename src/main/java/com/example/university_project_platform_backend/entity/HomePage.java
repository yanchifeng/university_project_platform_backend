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
 * @since 2024-04-11
 */
@Getter
@Setter
@TableName("home_page")
public class HomePage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "home_page_id", type = IdType.AUTO)
    private Integer homePageId;

    private String homePageTitle;

    private String homePageContext;

    private LocalDateTime homePageCreateTime;

    private Long homePageCreator;

    private String homePageCreatorName;

    private String homePageTag;
}
