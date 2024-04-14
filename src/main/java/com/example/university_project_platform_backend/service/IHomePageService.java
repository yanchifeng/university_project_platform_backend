package com.example.university_project_platform_backend.service;

import com.example.university_project_platform_backend.entity.HomePage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-11
 */
public interface IHomePageService extends IService<HomePage> {

    Map<String, Object> getHomePagesFormHomePageID(long homePageid);

    boolean homePageDelete(Integer homePageId);

    Map<String, Object> homePageUpdate(HomePage homePage);
}
