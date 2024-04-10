package com.example.university_project_platform_backend.controller;

import com.alibaba.fastjson2.JSONObject;
import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.entity.WebSocketUser;
import com.example.university_project_platform_backend.entity.Websocket;
import com.example.university_project_platform_backend.service.IWebSocketServer;
import com.example.university_project_platform_backend.service.impl.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
@RequestMapping("/chatServer")
public class WebSocketServerController {
    @Autowired
    IWebSocketServer iWebSocketServer;
    @ResponseBody
    @GetMapping("/daping")
    public void gettable(String userId){

        System.out.println(userId);


        //创建业务消息信息
        JSONObject obj = new JSONObject();
        obj.put("cmd", "topic");//业务类型
        obj.put("msgId", userId);//消息id
        obj.put("msgTxt", "dfadsfsacasfa案件非常差那上次");//消息内容
//全体发送
//        iWebSocketServer.sendAllMessage(obj.toJSONString());
//单个用户发送 (userId为用户id)
//        iWebSocketServer.sendOneMessage(userId, obj.toJSONString());
//        多个用户发送 (userIds为多个用户id，逗号‘,’分隔)
//        iWebSocketServer .sendMoreMessage(new String[]{userId, "33"}, obj.toJSONString());
    }


    @PostMapping("/sendForUser")
    public JsonResult<Map<String, Object>> sendForUser(@RequestBody Websocket webSocketUser){
        System.out.println(webSocketUser.toString());
        webSocketUser.setWebsocketTime(LocalDateTime.now());
        Map<String,Object> keys =iWebSocketServer.sendMessageForUser(webSocketUser);
        System.out.println(keys.get("data"));
        return JsonResult.ResultSuccess(keys);
    }


    @PostMapping("/getMessage")
    public JsonResult<Map<String, Object>> sendForAll(@RequestBody Websocket webSocketUser){
        Map<String,Object> keys =iWebSocketServer.getWebSocketUserMap();
        System.out.println(keys.size());
        return JsonResult.ResultSuccess(keys);
    }

    @PostMapping("/sendForUserList")
    public JsonResult<Map<String, Object>> sendForUserList(@RequestBody WebSocketUser webSocketUser){
        System.out.println(webSocketUser.toString());
        webSocketUser.setWebsocketTime(LocalDateTime.now());
        Map<String,Object> keys =iWebSocketServer.sendMessageForUserList(webSocketUser);
        return JsonResult.ResultSuccess(keys);
    }
}
