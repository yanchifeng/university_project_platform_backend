package com.example.university_project_platform_backend.service.impl;

import com.example.university_project_platform_backend.service.IWebSocketServer;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@Slf4j
@ServerEndpoint("/chatService/{loginName}")
public class WebSocketServer implements IWebSocketServer {
    /**
     * 存储每一个连接
     */
    private static final CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();

    /**
     * 会话
     */
    private Session session;

    /**
     * 登录名
     */
    private String loginName = "";


    /**
     * 在开放
     *
     * @param session   会话
     * @param loginName 登录名
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("loginName") String loginName) {
        // 前端连接得到登陆名称
        this.loginName = loginName;
        // 当前websokcet生成的会话
        this.session = session;
        webSocketSet.add(this);
        try {
            sendMessage("success");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * 在关闭
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
    }


    /**
     * 在消息
     *
     * @param message 消息
     * @param session 会话
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("接收到来自[" + message + "]发送的消息" + session);
        // 发送消息
//        for (WebSocketServer item : webSocketSet) {
//            try {
//                item.sendMessage(message + ",时间:" + new Date() + session);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }

    /**
     * 在错误
     *
     * @param session 会话
     * @param error   错误
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    /**
     * 发送消息
     *
     * @param message 消息
     */
    public void sendMessage(String message) {
        try {
            if (this.session != null) {
                this.session.getBasicRemote().sendText(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送信息
     * 发送指定消息给某个用户
     *
     * @param userName 用户名
     * @param msgStr   消息信息
     */
    public static void sendInfo(String userName, String msgStr) {
        for (WebSocketServer item : webSocketSet) {
            if (item.loginName.equals(userName)) {
                item.sendMessage(msgStr);
            }
        }
    }


}
