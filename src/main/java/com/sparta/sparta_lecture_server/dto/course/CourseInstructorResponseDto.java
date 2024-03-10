package com.sparta.sparta_lecture_server.dto.course;

import com.sparta.sparta_lecture_server.dto.instructor.response.InstructorResponseDto;
import com.sparta.sparta_lecture_server.entity.course.Category;
import com.sparta.sparta_lecture_server.entity.course.Course;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CourseInstructorResponseDto {
    private String title;

    private int price;

    private Category category;

    private String description;

    private InstructorResponseDto instructorResponseDto;

    private LocalDate registerDate;

    public CourseInstructorResponseDto(Course course) {
        this.title = course.getTitle();
        this.price = course.getPrice();
        this.category = course.getCategory();
        this.description = course.getDescription();
        this.instructorResponseDto = new InstructorResponseDto(course.getInstructor());
        this.registerDate = course.getRegisterDate();
    }
}
