package com.sparta.sparta_lecture_server.service;

import com.sparta.sparta_lecture_server.dto.course.CourseCategoryResponseDto;
import com.sparta.sparta_lecture_server.dto.course.CourseRequestDto;
import com.sparta.sparta_lecture_server.dto.course.CourseInstructorResponseDto;
import com.sparta.sparta_lecture_server.entity.course.Category;

import java.util.List;

public interface CourseService {

    CourseInstructorResponseDto save(CourseRequestDto courseRequestDto);

    CourseInstructorResponseDto findById(Long courseId);

    List<CourseCategoryResponseDto> findByCategory(Category category, String sortBy, boolean isAsc);
}
