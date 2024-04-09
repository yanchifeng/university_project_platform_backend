package com.example.university_project_platform_backend.service;

import com.example.university_project_platform_backend.entity.WebSocketUser;
import com.example.university_project_platform_backend.entity.Websocket;
import jakarta.websocket.Session;

import java.util.Map;

public interface IWebSocketServer {
    void onOpen(Session session, String loginName);

    //    void sendOneMessage(String userId, String jsonString);
//
//    void sendAllMessage(String jsonString);
//
//    void sendMoreMessage(String[] strings, String jsonString);
    Map<String, Object> sendMessageForUser(Websocket webSocketUser);

    Map<String, Object> getWebSocketUserMap();
}
