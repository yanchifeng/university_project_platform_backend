package com.example.university_project_platform_backend.controller.dto;

import com.example.university_project_platform_backend.entity.Project;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CompetitionProjectDTO extends Project {
    private Long competitionId;

}
