package com.sparta.sparta_lecture_server.dto.course;

import com.sparta.sparta_lecture_server.entity.Instructor.Instructor;
import com.sparta.sparta_lecture_server.entity.course.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CourseRequestDto {
    @NotBlank
    private String title;
    @NotBlank
    private int price;
    @NotBlank
    private Category category;
    @NotBlank
    private Long instructor_id;
    @NotBlank
    private String description;

}
