package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.entity.CreditsOperation;
import com.example.university_project_platform_backend.entity.Student;
import com.example.university_project_platform_backend.service.ICreditsOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-01
 */
@Controller
@RequestMapping("/creditsOperation")
public class CreditsOperationController {
    @Autowired
    private ICreditsOperationService iCreditsOperationService;
    @GetMapping("/show")
    public JsonResult<List<CreditsOperation>> creditsOperationShow(){
        List<CreditsOperation> creditsOperationList = iCreditsOperationService.list();
        System.out.println(creditsOperationList);
        return JsonResult.ResultSuccess(creditsOperationList);
    }

}
