package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.entity.User;
import com.example.university_project_platform_backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.example.university_project_platform_backend.common.JsonResult;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("/show")
    public JsonResult<List<User>> userShow(){
        List<User> list = iUserService.list();
        System.out.println("running");
        System.out.println(list);
        return JsonResult.ResultSuccess(list);
    }

    @PostMapping("/login")
    public JsonResult<Map<String,Object>> userLogin(@RequestBody User user){
        Map<String,Object> data = iUserService.login(user);
        if (data !=null){
            return JsonResult.ResultSuccess(data);
        }else {
            return JsonResult.ResultFail("用户名或者密码错误");
        }
    }


    @GetMapping("/info")
    public JsonResult<Map<String,Object>> userInfor(@RequestParam("token") String token){
        //根据token获取用户信息redis
        Map<String,Object> data = iUserService.info(token);
        if (data!=null){
            return JsonResult.ResultSuccess(data);
        }else {
            return JsonResult.ResultFail(403,"登录信息无效");
        }
    }

    @PostMapping("/register")
    public JsonResult<Map<String,Object>> userRegister(@RequestBody User user){
        Map<String,Object> data = iUserService.register(user);
        if (data.get("detailMessage") == null){
            return JsonResult.ResultSuccess(data);
        }else {
            return JsonResult.ResultFail(403,(String)data.get("detailMessage"));
        }
    }
}
