package com.example.university_project_platform_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableLoadTimeWeaving;


@SpringBootApplication
@MapperScan("com.example.university_project_platform_backend.mapper")
public class UniversityProjectPlatformBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniversityProjectPlatformBackendApplication.class, args);
    }

}
