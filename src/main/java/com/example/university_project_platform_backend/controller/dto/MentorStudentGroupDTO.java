package com.example.university_project_platform_backend.controller.dto;

import com.example.university_project_platform_backend.entity.StudentGroup;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MentorStudentGroupDTO extends StudentGroup {
    private Long mentorId;

    public MentorStudentGroupDTO(StudentGroup studentGroup,Long mentorId) {
        super.setGroupId(studentGroup.getGroupId());
        super.setGroupName(studentGroup.getGroupName());
        super.setGroupMentorId(studentGroup.getGroupMentorId());
        super.setGroupCaptainId(studentGroup.getGroupCaptainId());
        super.setGroupStudentId(studentGroup.getGroupStudentId());
        this.setGroupCreateTime(studentGroup.getGroupCreateTime());
        this.mentorId = mentorId;
    }

}
