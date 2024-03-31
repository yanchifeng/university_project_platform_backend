package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.entity.CreditsOperation;
import com.example.university_project_platform_backend.entity.ProjectManagementOperation;
import com.example.university_project_platform_backend.service.IProjectManagementOperationService;
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
@RequestMapping("/projectManagementOperation")
public class ProjectManagementOperationController {
    @Autowired
    private IProjectManagementOperationService iProjectManagementOperationService;
    @GetMapping("/show")
    public JsonResult<List<ProjectManagementOperation>> projectManagementOperationShow(){
        List<ProjectManagementOperation> projectManagementOperationList = iProjectManagementOperationService.list();
        System.out.println(projectManagementOperationList);
        return JsonResult.ResultSuccess(projectManagementOperationList);
    }


}
