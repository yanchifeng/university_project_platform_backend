package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.entity.Student;
import com.example.university_project_platform_backend.entity.StudentGroup;
import com.example.university_project_platform_backend.service.IStudentGroupService;
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
@RequestMapping("/studentGroup")
public class StudentGroupController {
    @Autowired
    private IStudentGroupService istudentGroupService;
    @GetMapping("/show")
    public JsonResult<List<StudentGroup>> studentGroupShow()
    {
        List<StudentGroup> studentGroupList = istudentGroupService.list();
        System.out.println(studentGroupList);
        return JsonResult.ResultSuccess(studentGroupList);
    }

    //需要验证是否为教师权限
    @PostMapping("/add")
    public JsonResult<Map<String,Object>> studentGroupAdd(@RequestBody StudentGroup studentGroup){
        boolean studentGroupFlag = istudentGroupService.save(studentGroup);
        long studentGroupId = studentGroup.getGroupId();
        if (studentGroupFlag){
            return JsonResult.ResultSuccess(istudentGroupService.getStudentGroupsFormStudentID(studentGroupId));
        }
        return JsonResult.ResultFail(204,"找不到数据");
    }
    
    //需要验证是否为教师权限
    @PostMapping("/del")
    public JsonResult<Map<String,Object>> studentDelete(@RequestBody StudentGroup studentGroup){
        boolean studentFlag = istudentGroupService.studentGroupDelete(studentGroup.getGroupId());
        if (studentFlag){
            return JsonResult.ResultSuccess("删除成功 [ "+studentGroup.getGroupId()+" ]");
        }
        return JsonResult.ResultFail("删除失败 [ "+studentGroup.getGroupId()+" ] 找不到ID或数据冲突");
    }


    @PostMapping("/change")
    public JsonResult<Map<String,Object>> studentChange(@RequestBody StudentGroup studentGroup){
        Map<String,Object> data = istudentGroupService.studentGroupUpdate(studentGroup);
        if (data!=null){
            return JsonResult.ResultSuccess(data);
        }else {
            return JsonResult.ResultFail();
        }
    }
}
