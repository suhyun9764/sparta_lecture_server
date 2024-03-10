package com.sparta.sparta_lecture_server.dto.instructor.response;

import com.sparta.sparta_lecture_server.entity.Instructor.Instructor;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class InstructorResponseDto {
    private Long id;

    private String name;

    private int experience;

    private String company;

    private String phone;

    private String intro;


    public InstructorResponseDto(Instructor instructor) {
        this.id = instructor.getId();
        this.name = instructor.getName();
        this.experience = instructor.getExperience();
        this.company = instructor.getCompany();
        this.phone = instructor.getPhone();
        this.intro = instructor.getIntro();
    }
}
