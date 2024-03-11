package com.sparta.sparta_lecture_server.dto.course.request;

import com.sparta.sparta_lecture_server.entity.course.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CourseRequestDto {
    @NotBlank
    private String title;
    @NotNull
    private int price;
    @NotBlank
    private Category category;
    @NotBlank
    private Long instructor_id;
    @NotBlank
    private String description;

}
