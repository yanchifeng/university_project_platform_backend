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
 * @since 2024-04-11
 */
@Getter
@Setter
public class Websocket implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "websocket_id", type = IdType.AUTO)
    private Integer websocketId;

    private Long websocketUserId;

    private String websocketForuser;

    private String websocketMessage;

    private LocalDateTime websocketTime;
}
