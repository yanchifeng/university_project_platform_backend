package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.entity.Project;
import com.example.university_project_platform_backend.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private IProjectService iProjectService;

    @GetMapping("/show")
    public JsonResult<List<Project>> projectShow() {
        List<Project> projectList = iProjectService.list();
        System.out.println(projectList);
        return JsonResult.ResultSuccess(projectList);
    }


}
