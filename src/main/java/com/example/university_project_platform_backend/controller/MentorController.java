package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.controller.dto.MentorStudentGroupDTO;
import com.example.university_project_platform_backend.entity.Mentor;
import com.example.university_project_platform_backend.entity.StudentGroup;
import com.example.university_project_platform_backend.service.IMentorService;
import com.example.university_project_platform_backend.service.IStudentGroupService;
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

import java.util.Collections;
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
    @Autowired
    private IStudentGroupService iStudentGroupService;

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

    @PostMapping("/studentGroupAdd")
    public JsonResult<Map<String,Object>> mentorStudentGroupAdd(@RequestBody StudentGroup studentGroup){
        boolean studentGroupFlag = iStudentGroupService.save(studentGroup);
        long studentGroupId = studentGroup.getGroupId();
        if (studentGroupFlag){
            return JsonResult.ResultSuccess(iStudentGroupService.getStudentGroupsFormStudentID(studentGroupId));
        }
        return JsonResult.ResultFail(204,"找不到数据");
    }

    @PostMapping("/studentGroupDel")
    public JsonResult<Map<String,Object>> mentorStudentGroupDel(@RequestBody StudentGroup studentGroup){
        boolean studentGroupFlag = iStudentGroupService.studentGroupDeleteByMentorId(studentGroup.getGroupMentorId(),studentGroup.getGroupId());
        if (studentGroupFlag){
            return JsonResult.ResultSuccess("删除成功 [ "+studentGroup.getGroupId()+" ]");
        }
        return JsonResult.ResultFail("删除失败 [ "+studentGroup.getGroupId()+" ] 找不到ID或数据冲突");
    }

    @PostMapping("/studentGroupChange")
    public JsonResult<Map<String,Object>> mentorStudentGroupChange(@RequestBody StudentGroup studentGroup){
        Map<String,Object> data = iStudentGroupService.studentGroupUpdateByMentorId(studentGroup.getGroupMentorId(),studentGroup);
        if (data!=null){
            return JsonResult.ResultSuccess(data);
        }else {
            return JsonResult.ResultFail();
        }
    }

    @PostMapping("/studentGroupSearch")
    public JsonResult<Map<String,Object>> mentorStudentGroupSearch(@RequestBody MentorStudentGroupDTO mentorStudentGroupDTO){
        Map<String,Object> studentGroupList = iStudentGroupService.studentGroupShowByMentorId(mentorStudentGroupDTO.getGroupMentorId());
        if (studentGroupList!=null){
            System.out.println("success");
            return JsonResult.ResultSuccess(studentGroupList);
        }else {
            return JsonResult.ResultFail("查询不到该导师存在导师组");
        }
    }


    @PostMapping("/studentGroupShow")
    public JsonResult<Map<String,Object>> mentorStudentGroupShow(@RequestBody StudentGroup studentGroup){
        Map<String,Object> studentGroupList = iStudentGroupService.studentGroupShowByMentorId(studentGroup.getGroupMentorId());
        System.out.println(studentGroupList.toString());
        if (!studentGroupList.isEmpty()){
            System.out.println("success");
            return JsonResult.ResultSuccess(studentGroupList);
        }else {
            return JsonResult.ResultSuccess();
        }
    }
}
