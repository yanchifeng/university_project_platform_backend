package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.controller.dto.UserCreditsDTO;
import com.example.university_project_platform_backend.entity.Credits;
import com.example.university_project_platform_backend.entity.Student;
import com.example.university_project_platform_backend.service.ICreditsOperationService;
import com.example.university_project_platform_backend.service.ICreditsService;
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
 * @since 2024-03-30
 */
@RestController
@RequestMapping("/credits")
public class CreditsController {

    @Autowired
    private ICreditsService iCreditsService;
    @Autowired
    private ICreditsOperationService iCreditsOperationService;

    @GetMapping("/show")
    public JsonResult<List<Credits>> creditsShow() {
        List<Credits> creditsList = iCreditsService.list();
        System.out.println(creditsList);
        return JsonResult.ResultSuccess(creditsList);
    }

    @PostMapping("/add")
    public JsonResult<Map<String, Object>> creditsAdd(@RequestBody UserCreditsDTO credits) {
        long userId = credits.getCreditsOperationOperator();
        boolean isSuccess;
        boolean saveSuccess;
        try {
             isSuccess = iCreditsService.creditsAdd(userId,credits);
             saveSuccess = iCreditsOperationService.creditsOperationAdd(userId,credits, isSuccess);
        }catch (Exception e){
            isSuccess = false;
            saveSuccess = iCreditsOperationService.creditsOperationAdd(userId,credits, isSuccess);
        }
        if (isSuccess&&saveSuccess) {
            return JsonResult.ResultSuccess("添加成功");
        } else {
            return JsonResult.ResultFail("添加失败");
        }
    }

    @PostMapping("/del")
    public JsonResult<Map<String, Object>> creditsDel(@RequestBody Credits credits) {
        boolean isSuccess = iCreditsService.removeById(credits.getCreditsId());
        if (isSuccess) {
            return JsonResult.ResultSuccess("删除成功");
        } else {
            return JsonResult.ResultFail("删除失败");
        }
    }

    @PostMapping("/update")
    public JsonResult<Map<String, Object>> creditsUpdate(@RequestBody Credits credits) {
        boolean isSuccess = iCreditsService.updateById(credits);
        if (isSuccess) {
            return JsonResult.ResultSuccess("更新成功");
        } else {
            return JsonResult.ResultFail("更新失败");
        }
    }

    @PostMapping("/getCredits")
    public JsonResult<Map<String, Object>> getCredits(@RequestBody Student student) {
        Long studentId = student.getStudentId();
        Map<String,Object> creditsList = iCreditsService.getCreditsByStudentId(studentId);
        System.out.println(creditsList);
        return JsonResult.ResultSuccess(creditsList);
    }

}
