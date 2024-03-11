package com.sparta.sparta_lecture_server.dto.course.response;

import com.sparta.sparta_lecture_server.dto.instructor.response.InstructorResponseDto;
import com.sparta.sparta_lecture_server.entity.course.Category;
import com.sparta.sparta_lecture_server.entity.course.Course;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CourseCategoryResponseDto {
    private String title;

    private int price;

    private Category category;

    private String description;

    private LocalDate registerDate;

    public CourseCategoryResponseDto(Course course) {
        this.title = course.getTitle();
        this.price = course.getPrice();
        this.category = course.getCategory();
        this.description = course.getDescription();
        this.registerDate = course.getRegisterDate();
    }
}
