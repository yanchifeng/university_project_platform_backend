package com.example.university_project_platform_backend.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WebSocketUser {
    private String userId;
    private String password;
    private String massage;
    private String token;

}
