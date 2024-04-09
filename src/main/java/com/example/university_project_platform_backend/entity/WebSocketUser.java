package com.example.university_project_platform_backend.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class WebSocketUser {
    private String userId;
    private String password;
    private String message;
    private String token;
    private String forUser;

    private LocalDateTime time;
}
