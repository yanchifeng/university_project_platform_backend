package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.entity.Student;
import com.example.university_project_platform_backend.service.IStudentService;
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
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @PostMapping("/test")
    public JsonResult<Object> studentTest(@RequestBody String studentId){
        System.out.println("studentTest Running ：" + studentId);
        return JsonResult.ResultSuccess(iStudentService.isStudentFormStudentID(studentId));
    }

    @GetMapping("/show")
    public JsonResult<List<Student>> studentShow(){
        List<Student> studentList = iStudentService.list();
        System.out.println(studentList);
        return JsonResult.ResultSuccess(studentList);
    }


    @PostMapping("/add")
    public JsonResult<Map<String, Object>> studentAdd(@RequestBody Student student){
        boolean studentFlag = iStudentService.save(student);
        long studentid = student.getStudentId();
        if (studentFlag){
            return JsonResult.ResultSuccess(iStudentService.getStudentsFormStudentID(studentid));
        }
        return JsonResult.ResultFail(204,"找不到数据");
    }

    @PostMapping("/del")
    public JsonResult<Map<String,Object>> studentDelete(@RequestBody Student student){
        boolean studentFlag = iStudentService.studentDelete(student.getStudentId());
        if (studentFlag){
            return JsonResult.ResultSuccess("删除成功 [ "+student.getStudentId()+" ]");
        }
        return JsonResult.ResultFail("删除失败 [ "+student.getStudentId()+" ] 找不到ID或数据冲突");
    }

    @PostMapping("/change")
    public JsonResult<Map<String,Object>> studentChange(@RequestBody Student student){
        Map<String,Object> data = iStudentService.studentUpdate(student);
        if (data!=null){
            return JsonResult.ResultSuccess(data);
        }else {
            return JsonResult.ResultFail();
        }
    }
}
