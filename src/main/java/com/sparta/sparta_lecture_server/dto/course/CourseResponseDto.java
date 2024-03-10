package com.sparta.sparta_lecture_server.dto.course;

import com.sparta.sparta_lecture_server.dto.instructor.response.InstructorResponseDto;
import com.sparta.sparta_lecture_server.entity.Instructor.Instructor;
import com.sparta.sparta_lecture_server.entity.course.Category;
import com.sparta.sparta_lecture_server.entity.course.Course;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
public class CourseResponseDto {
    private String title;

    private int price;

    private Category category;

    private String description;

    private InstructorResponseDto instructorResponseDto;

    private LocalDate registerDate;

    public CourseResponseDto(Course course) {
        this.title = course.getTitle();
        this.price = course.getPrice();
        this.category = course.getCategory();
        this.description = course.getDescription();
        this.instructorResponseDto = new InstructorResponseDto(course.getInstructor());
        this.registerDate = course.getRegisterDate();
    }
}
