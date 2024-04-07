package com.example.university_project_platform_backend.service;

import jakarta.websocket.Session;

public interface IWebSocketServer  {
    void onOpen(Session session,String loginName);
}
