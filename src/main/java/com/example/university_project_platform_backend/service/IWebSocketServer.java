package com.example.university_project_platform_backend.service;

import jakarta.websocket.Session;

public interface IWebSocketServer  {
    void onOpen(Session session,String loginName);

//    void sendOneMessage(String userId, String jsonString);
//
//    void sendAllMessage(String jsonString);
//
//    void sendMoreMessage(String[] strings, String jsonString);
    void sendMessageForUser(String userId,String message);
}
