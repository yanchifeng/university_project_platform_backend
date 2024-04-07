package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.service.impl.WebSocketServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chatServer")
public class WebSocketServerController {
    @GetMapping("/sendMessage")
    public String sendMessage(String userName){
        WebSocketServer.sendInfo(userName,"你好");
        return "yes";
    }
}
