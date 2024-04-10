package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.entity.Project;
import com.example.university_project_platform_backend.entity.StudentGroup;
import com.example.university_project_platform_backend.service.IProjectService;
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

    @PostMapping("/projectSearch")
    public JsonResult<Map<String, Object>> projectSearch(@RequestBody Project project) {
        Map<String, Object> studentGroupList = iProjectService.projectSearchByProject(project);
        if (studentGroupList != null) {
            System.out.println("success");
            return JsonResult.ResultSuccess(studentGroupList);
        } else {
            return JsonResult.ResultFail("查询不到该导师存在导师组");
        }
    }

    @GetMapping("/getProjectNew")
    public JsonResult<Map<String, Object>> getProjectNew() {
        Map<String, Object> studentGroupList = iProjectService.getProjectNew();
        if (studentGroupList != null) {
            System.out.println("success");
            return JsonResult.ResultSuccess(studentGroupList);
        } else {
            return JsonResult.ResultFail("查询不到该导师存在导师组");
        }
    }
}
