package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.entity.Mentor;
import com.example.university_project_platform_backend.service.IMentorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
import com.example.university_project_platform_backend.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

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
@RequestMapping("/mentor")
public class MentorController {
    @Autowired
    private IMentorService iMentorService;

    @PostMapping("/test")
    public JsonResult<Object> mentorTest(@RequestBody String mentorId){
        System.out.println("mentorTest Running ：" + mentorId);
        return JsonResult.ResultSuccess(iMentorService.isMentorFromMentorID(mentorId));
    }

    @GetMapping("/show")
    public JsonResult<List<Mentor>> mentorShow(){
        List<Mentor> mentorList = iMentorService.list();
        System.out.println(mentorList);
        return JsonResult.ResultSuccess(mentorList);
    }


    @PostMapping("/add")
    public JsonResult<Map<String, Object>> mentorAdd(@RequestBody Mentor mentor){
        boolean mentorFlag = iMentorService.save(mentor);
        long mentorid = mentor.getMentorId();
        if (mentorFlag){
            return JsonResult.ResultSuccess(iMentorService.getMentorsFormMentorID(mentorid));
        }
        return JsonResult.ResultFail(204,"找不到数据");
    }

    @PostMapping("/del")
    public JsonResult<Map<String,Object>> mentorDelete(@RequestBody Mentor mentor){
        boolean mentorFlag = iMentorService.mentorDelete(mentor.getMentorId());
        if (mentorFlag){
            return JsonResult.ResultSuccess("删除成功 [ "+mentor.getMentorId()+" ]");
        }
        return JsonResult.ResultFail("删除失败 [ "+mentor.getMentorId()+" ] 找不到ID或数据冲突");
    }

    @PostMapping("/change")
    public JsonResult<Map<String,Object>> mentorChange(@RequestBody Mentor mentor){
        Map<String,Object> data = iMentorService.mentorUpdate(mentor);
        if (data!=null){
            return JsonResult.ResultSuccess(data);
        }else {
            return JsonResult.ResultFail();
        }
    }
}
