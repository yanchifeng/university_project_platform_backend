package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.university_project_platform_backend.entity.HomePage;
import com.example.university_project_platform_backend.entity.HomePage;
import com.example.university_project_platform_backend.entity.HomePage;
import com.example.university_project_platform_backend.entity.HomePage;
import com.example.university_project_platform_backend.mapper.HomePageMapper;
import com.example.university_project_platform_backend.service.IHomePageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-11
 */
@Service
public class HomePageServiceImpl extends ServiceImpl<HomePageMapper, HomePage> implements IHomePageService {

    @Override
    public Map<String, Object> getHomePagesFormHomePageID(long homePageId) {
        Map<String,Object> homePageMap = new HashMap<>();
        LambdaQueryWrapper<HomePage> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(HomePage::getHomePageId,homePageId);
        System.out.println(homePageId);
        List<HomePage> searchHomePageList = this.list(wrapper);
        homePageMap.put("data",searchHomePageList);
        return homePageMap;
    }

    @Override
    public boolean homePageDelete(Integer homePageId) {
        LambdaQueryWrapper<HomePage> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(HomePage::getHomePageId, homePageId);
        int homePageFlag = this.baseMapper.delete(wrapper);
        if (homePageFlag!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Map<String, Object> homePageUpdate(HomePage homePage) {
        LambdaQueryWrapper<HomePage> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(HomePage::getHomePageId,homePage.getHomePageId());
        boolean homePageFlag = this.update(homePage,wrapper);
        if (homePageFlag){
            HomePage homePageList = this.getOne(wrapper);
            Map<String,Object> homePageMap = new HashMap<>();
            homePageMap.put("data",homePageList);
            return homePageMap;
        }
        return null;
    }
}
