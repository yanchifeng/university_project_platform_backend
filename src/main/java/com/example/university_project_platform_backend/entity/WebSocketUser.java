package com.example.university_project_platform_backend.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class WebSocketUser extends Websocket{
    private List<String> userList;
}
