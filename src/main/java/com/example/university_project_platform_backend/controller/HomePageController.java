package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.entity.HomePage;
import com.example.university_project_platform_backend.service.IHomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-11
 */
@Controller
@RequestMapping("/homePage")
public class HomePageController {
    @Autowired
    IHomePageService iHomePageService;
    @GetMapping("/show")
    public JsonResult<List<HomePage>> homePageShow() {
        List<HomePage> homePageList = iHomePageService.list();
        System.out.println(homePageList);
        return JsonResult.ResultSuccess(homePageList);
    }


    @PostMapping("/add")
    public JsonResult<Map<String, Object>> homePageAdd(@RequestBody HomePage homePage) {
        boolean homePageFlag = iHomePageService.save(homePage);
        long homePageid = homePage.getHomePageId();
        if (homePageFlag) {
            return JsonResult.ResultSuccess(iHomePageService.getHomePagesFormHomePageID(homePageid));
        }
        return JsonResult.ResultFail(204, "找不到数据");
    }

    @PostMapping("/del")
    public JsonResult<Map<String, Object>> homePageDelete(@RequestBody HomePage homePage) {
        boolean homePageFlag = iHomePageService.homePageDelete(homePage.getHomePageId());
        if (homePageFlag) {
            return JsonResult.ResultSuccess("删除成功 [ " + homePage.getHomePageId() + " ]");
        }
        return JsonResult.ResultFail("删除失败 [ " + homePage.getHomePageId() + " ] 找不到ID或数据冲突");
    }

    @PostMapping("/change")
    public JsonResult<Map<String, Object>> homePageChange(@RequestBody HomePage homePage) {
        Map<String, Object> data = iHomePageService.homePageUpdate(homePage);
        if (data != null) {
            return JsonResult.ResultSuccess(data);
        } else {
            return JsonResult.ResultFail();
        }
    }
}
