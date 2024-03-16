package com.example.university_project_platform_backend.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.university_project_platform_backend.common.TokenCommon;
import com.example.university_project_platform_backend.entity.User;
import com.example.university_project_platform_backend.mapper.UserMapper;
import com.example.university_project_platform_backend.service.IMentorService;
import com.example.university_project_platform_backend.service.IStudentService;
import com.example.university_project_platform_backend.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IStudentService iStudentService;
    @Autowired
    private IMentorService iMentorService;

    @Override
    public Map<String, Object> login(User user) {

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        System.out.println(user.getUserName());
        wrapper.eq(User::getUserName, user.getUserName());
        wrapper.eq(User::getUserPassword, user.getUserPassword());
        wrapper.eq(User::getUserPermission, user.getUserPermission());

        User loginUser = this.baseMapper.selectOne(wrapper);

        if (loginUser != null) {
            String key = TokenCommon.createToken(loginUser.getUserName(), loginUser.getUserPassword());
            redisTemplate.opsForValue().set(key, loginUser, 30, TimeUnit.MINUTES);
            Map<String, Object> data = new HashMap<>();
            data.put("data", loginUser);
            data.put("token", key);
            return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> info(String token) {
        Object obj = redisTemplate.opsForValue().get(token);
        if (obj != null) {
            User loginUser = JSON.parseObject(JSON.toJSONString(obj), User.class);
            Map<String, Object> data = new HashMap<>();
            data.put("userName", loginUser.getUserName());
            data.put("userPassword", loginUser.getUserPassword());
            data.put("userPermission", loginUser.getUserPermission());

            List<String> userName = null;
            long longUserName = Long.parseLong(loginUser.getUserName());
            if (longUserName>= 11000000000L&&longUserName <=12000000000L){
                userName = this.baseMapper.getMentorByName(loginUser.getUserName());
                System.out.println("returntoken:"+TokenCommon.getUserIdFormToken(token));
            }
            else if (longUserName >=  12000000000L && longUserName< 13000000000L ){
                userName = this.baseMapper.getStudentByName(loginUser.getUserName());
                System.out.println("returntoken:"+TokenCommon.getUserIdFormToken(token));
            }else {
                userName.add("admin");
            }
            data.put("data",userName);
            return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> register(User user) {

        Map<String, Object> registerData = new HashMap<>();
        long userName = Long.parseLong(user.getUserName());
        //查询user表中相关学生数量
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName, user.getUserName());
        List<User> searchUserList = this.list(wrapper);
        boolean flag = false;
        if (userName >=  11000000000L &&userName< 12000000000L && searchUserList.isEmpty()){
            System.out.println("Teacher_manage_running");
            flag =iMentorService.isMentorFromMentorID(user.getUserName());
            user.setUserPermission(1);
        }else if (userName >=  12000000000L &&userName< 13000000000L&& searchUserList.isEmpty()){
            System.out.println("Student_manage_running");
            flag =iStudentService.isStudentFormStudentID(user.getUserName());
            user.setUserPermission(2);
//            wrapper.setParamAlias("2");
        }else {
            if (searchUserList.isEmpty()){
                flag = false;
            }
        }

        if (flag) {
            //学生信息录入
            boolean data = this.save(user);
            if (data) {
                //查询录入成功的数据
                User registerUser = this.getOne(wrapper);
                if (registerUser != null) {
                    registerData.put("data", registerUser);
                    System.out.println(registerData);
                    return registerData;
                } else {
                    registerData.put("detailMessage","数据录入成功，但寻找不到该用户，请联系管理员");
                    return registerData;
                }
            } else {
                registerData.put("detailMessage", "用户数据录入失败");
                return registerData;
            }
        }else {
            registerData.put("detailMessage","信息录入失败，学生和教师数据中没有该用户，或者管理员数据冲突");
            return registerData;
        }
    }
}
