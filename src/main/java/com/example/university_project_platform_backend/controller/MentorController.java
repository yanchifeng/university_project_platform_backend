package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.controller.dto.MentorProjectDTO;
import com.example.university_project_platform_backend.entity.Mentor;
import com.example.university_project_platform_backend.entity.Project;
import com.example.university_project_platform_backend.entity.ProjectManagement;
import com.example.university_project_platform_backend.entity.StudentGroup;
import com.example.university_project_platform_backend.service.IMentorService;
import com.example.university_project_platform_backend.service.IProjectManagementService;
import com.example.university_project_platform_backend.service.IProjectService;
import com.example.university_project_platform_backend.service.IStudentGroupService;
import org.springframework.web.bind.annotation.RequestMapping;

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

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
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
    @Autowired
    private IProjectManagementService iProjectManagementService;
    @Autowired
    private IProjectService iProjectService;

    @PostMapping("/test")
    public JsonResult<Object> mentorTest(@RequestBody String mentorId) {
        System.out.println("mentorTest Running ：" + mentorId);
        return JsonResult.ResultSuccess(iMentorService.isMentorFromMentorID(mentorId));
    }

    @GetMapping("/show")
    public JsonResult<List<Mentor>> mentorShow() {
        List<Mentor> mentorList = iMentorService.list();
        System.out.println(mentorList);
        return JsonResult.ResultSuccess(mentorList);
    }


    @PostMapping("/add")
    public JsonResult<Map<String, Object>> mentorAdd(@RequestBody Mentor mentor) {
        boolean mentorFlag = iMentorService.save(mentor);
        long mentorid = mentor.getMentorId();
        if (mentorFlag) {
            return JsonResult.ResultSuccess(iMentorService.getMentorsFormMentorID(mentorid));
        }
        return JsonResult.ResultFail(204, "找不到数据");
    }

    @PostMapping("/del")
    public JsonResult<Map<String, Object>> mentorDelete(@RequestBody Mentor mentor) {
        boolean mentorFlag = iMentorService.mentorDelete(mentor.getMentorId());
        if (mentorFlag) {
            return JsonResult.ResultSuccess("删除成功 [ " + mentor.getMentorId() + " ]");
        }
        return JsonResult.ResultFail("删除失败 [ " + mentor.getMentorId() + " ] 找不到ID或数据冲突");
    }

    @PostMapping("/change")
    public JsonResult<Map<String, Object>> mentorChange(@RequestBody Mentor mentor) {
        Map<String, Object> data = iMentorService.mentorUpdate(mentor);
        if (data != null) {
            return JsonResult.ResultSuccess(data);
        } else {
            return JsonResult.ResultFail();
        }
    }

    @PostMapping("/studentGroupAdd")
    public JsonResult<Map<String, Object>> mentorStudentGroupAdd(@RequestBody StudentGroup studentGroup) {
        boolean studentGroupFlag = iStudentGroupService.save(studentGroup);
        long studentGroupId = studentGroup.getGroupId();
        if (studentGroupFlag) {
            return JsonResult.ResultSuccess(iStudentGroupService.getStudentGroupsFormStudentID(studentGroupId));
        }
        return JsonResult.ResultFail(204, "找不到数据");
    }

    @PostMapping("/studentGroupDel")
    public JsonResult<Map<String, Object>> mentorStudentGroupDel(@RequestBody StudentGroup studentGroup) {
        boolean studentGroupFlag = iStudentGroupService.studentGroupDeleteByMentorId(studentGroup.getGroupMentorId(), studentGroup.getGroupId());
        if (studentGroupFlag) {
            return JsonResult.ResultSuccess("删除成功 [ " + studentGroup.getGroupId() + " ]");
        }
        return JsonResult.ResultFail("删除失败 [ " + studentGroup.getGroupId() + " ] 找不到ID或数据冲突");
    }

    @PostMapping("/studentGroupChange")
    public JsonResult<Map<String, Object>> mentorStudentGroupChange(@RequestBody StudentGroup studentGroup) {
        Map<String, Object> data = iStudentGroupService.studentGroupUpdateByMentorId(studentGroup.getGroupMentorId(), studentGroup);
        if (data != null) {
            return JsonResult.ResultSuccess(data);
        } else {
            return JsonResult.ResultFail();
        }
    }

    @PostMapping("/studentGroupSearch")
    public JsonResult<Map<String, Object>> mentorStudentGroupSearch(@RequestBody StudentGroup studentGroup) {
        Map<String, Object> studentGroupList = iStudentGroupService.studentGroupSearchByStudentGroup(studentGroup);
        if (studentGroupList != null) {
            System.out.println("success");
            return JsonResult.ResultSuccess(studentGroupList);
        } else {
            return JsonResult.ResultFail("查询不到该导师存在导师组");
        }
    }


    @PostMapping("/studentGroupShow")
    public JsonResult<Map<String, Object>> mentorStudentGroupShow(@RequestBody StudentGroup studentGroup) {
        Map<String, Object> studentGroupList = iStudentGroupService.studentGroupShowByMentorId(studentGroup.getGroupMentorId());
        System.out.println(studentGroupList.toString());
        if (!studentGroupList.isEmpty()) {
            System.out.println("success");
            return JsonResult.ResultSuccess(studentGroupList);
        } else {
            return JsonResult.ResultSuccess();
        }
    }

    @PostMapping("/projectUpdate")
    public JsonResult<Map<String, Object>> projectUpdate(@RequestBody Project project) {
        Long mentorId = project.getProjectCreator();
        Map<String, Object> data = iProjectService.projectUpdateByProjectCreator(mentorId, project);
        if (data != null) {
            return JsonResult.ResultSuccess(data);
        } else {
            return JsonResult.ResultFail();
        }
    }

    @PostMapping("/projectDel")
    public JsonResult<Map<String, Object>> projectDel(@RequestBody Project project) {
        Long mentorId = project.getProjectCreator();
        boolean projectFlag = iProjectService.projectDeleteByProjectCreator(mentorId, project.getProjectId());
        if (projectFlag) {
            return JsonResult.ResultSuccess("删除成功 [ " + project.getProjectId() + " ]");
        }
        return JsonResult.ResultFail();
    }

    //目前
    @PostMapping("/projectManagementAdd")
    public JsonResult<Map<String, Object>> projectManagementAdd(@RequestBody MentorProjectDTO mentorProjectDTO) {
        JsonResult<Map<String, Object>> jsonResult = iProjectManagementService.projectManagementSubmitByProjectMentorDTO(mentorProjectDTO);
        return jsonResult;
    }

    @PostMapping("/projectManagementShow")
    public JsonResult<Map<String, Object>> projectManagementShow(@RequestBody MentorProjectDTO mentorProjectDTO) {
        Map<String, Object> data = iProjectManagementService.projectManagementSelectByMentorProjectDTO(mentorProjectDTO);
        if (data != null) {
            return JsonResult.ResultSuccess(data);
        } else {
            return JsonResult.ResultFail();
        }
    }

    //待测试
    @PostMapping("/projectManagementUpdate")
    public JsonResult<Map<String, Object>> projectManagementUpdate(@RequestBody ProjectManagement projectManagement) {
        Long mentorId = projectManagement.getMentorId();
        Map<String, Object> data = iProjectManagementService.projectManagementUpdateByMentorId(mentorId,projectManagement);
        if (data != null) {
            return JsonResult.ResultSuccess(data);
        } else {
            return JsonResult.ResultFail();
        }
    }


    @PostMapping("/projectManagementDel")
    public JsonResult<Map<String, Object>> projectManagementDel(@RequestBody ProjectManagement projectManagement) {
        Long mentorId = projectManagement.getMentorId();
        boolean projectManagementFlag = iProjectManagementService.projectManagementDeleteByMentorId(mentorId,projectManagement.getProjectId());
        if (projectManagementFlag) {
            return JsonResult.ResultSuccess("删除成功 [ " + projectManagement.getProjectId() + " ]");
        }
        return JsonResult.ResultFail("删除失败 [ " + projectManagement.getProjectId() + " ] 找不到ID或数据冲突");
    }
}





