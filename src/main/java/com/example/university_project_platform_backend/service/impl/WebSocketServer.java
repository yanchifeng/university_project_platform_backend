package com.example.university_project_platform_backend.service.impl;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.entity.WebSocketUser;
import com.example.university_project_platform_backend.entity.Websocket;
import com.example.university_project_platform_backend.service.IWebSocketServer;
import com.example.university_project_platform_backend.service.IWebsocketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
@ServerEndpoint(value = "/myService/{userId}")
public class WebSocketServer implements IWebSocketServer {
    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static AtomicInteger onlineCount = new AtomicInteger(0);;
    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
     */
    private static ConcurrentHashMap<String,WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的session对象。
     */
    private static ConcurrentHashMap<String,Session> sessionMap = new ConcurrentHashMap<>();
    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;
    private String userId = "";
    ObjectMapper mapper = new ObjectMapper();

    private static final List<Websocket> webSocketUserList = new ArrayList<>();

    @Autowired
    private IWebsocketService iWebsocketService;


    public Map<String, Object> getWebSocketUserMap() {
        System.out.println("running:getWebSocketUserMap");
        Map<String, Object> webSocketUserMap = new HashMap<>();
        webSocketUserMap.put("data", webSocketUserList);
        return webSocketUserMap;
    }
    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session,@PathParam("userId") String userId) {
        this.session = session;
        this.userId = userId;
        if(webSocketMap.containsKey(userId) && sessionMap.containsKey(userId)){
            webSocketMap.remove(userId);
            sessionMap.remove(userId);
            sessionMap.put(userId,session);
            webSocketMap.put(userId,this);
        }else{
            webSocketMap.put(userId,this);
            sessionMap.put(userId,session);
            addOnlineCount();
        }
        log.info("用户连接:"+userId+",当前在线人数为:" + getOnlineCount());
    }
    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        if(webSocketMap.containsKey(userId)){
            webSocketMap.remove(userId);
            subOnlineCount();
        }
        log.info("用户退出:"+userId+",当前在线人数为:" + getOnlineCount());
    }
    /**
     * 收到客户端消息后调用的方法
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        this.session = session;
        log.info("收到客户端消息 -> {}",message);
        //服务端收到客户端的消息并推送给客户端
//        sendMessage(message);
//        sendMessageForUser(userId,message);
    }
    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error(error.getMessage());
    }
    /**
     * 实现服务器主动推送   可以通过controller调用此方法实现主动推送
     */
    public void sendMessage(String message){
        try {
            Set<Map.Entry<String, Session>> entries = sessionMap.entrySet();
            for (Map.Entry<String, Session> next : entries) {
                Session session = next.getValue();
                session.getBasicRemote().sendText(this.userId + "说" + message);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
    public static synchronized int getOnlineCount() {
        return onlineCount.get();
    }
    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount.getAndIncrement();
    }
    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount.getAndDecrement();
    }

    public Map<String,Object> sendMessageForUser(Websocket webSocketUser){
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
        mapper.registerModule(new JavaTimeModule());
        Map<String,Object> sendMessageForUserMap = new HashMap<>();
        String forUserId = webSocketUser.getWebsocketForuser();
        String message = webSocketUser.getWebsocketMessage();
        webSocketUser.setWebsocketTime(LocalDateTime.now());
        if(sessionMap.containsKey(forUserId)){
            Session session = sessionMap.get(forUserId);
            try {
                sendMessageForUserMap.put("data",webSocketUserList);
                webSocketUserList.add(webSocketUser);
                String messageStringMapper = mapper.writeValueAsString(webSocketUser);
                session.getBasicRemote().sendText(messageStringMapper);
//                for (int i = 0; i < webSocketUserList.size(); i++) {
//                    System.out.println(webSocketUserList.get(i).toString());
//                }
                boolean websocketFlag = iWebsocketService.save(webSocketUser);
                System.out.println("Flag:"+websocketFlag);
                if (websocketFlag){
                    log.info("发送成功");
                    return sendMessageForUserMap;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sendMessageForUserMap;
    }

    public Map<String,Object> sendMessageForUserList(Websocket webSocketUser){
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
        mapper.registerModule(new JavaTimeModule());
        Map<String,Object> sendMessageForUserMap = new HashMap<>();
        List<String> forUserList = Arrays.asList(webSocketUser.getWebsocketForuser().split(","));
        for (int i = 0; i < forUserList.size(); i++) {
            String forUserId = forUserList.get(i);
            System.out.println("forUserId:"+forUserId);
            if(sessionMap.containsKey(forUserId)){
                Session session = sessionMap.get(forUserId);
                try {
                    webSocketUser.setWebsocketTime(LocalDateTime.now());
                    webSocketUserList.add(webSocketUser);
                    sendMessageForUserMap.put("data",webSocketUserList);
                    String messageStringMapper = mapper.writeValueAsString(webSocketUser);
                    session.getBasicRemote().sendText(messageStringMapper);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        boolean websocketFlag = iWebsocketService.save(webSocketUser);
        if (websocketFlag){
            return sendMessageForUserMap;
        }else {
            return (Map<String, Object>) sendMessageForUserMap.put("message","发送失败");
        }
    }

}
