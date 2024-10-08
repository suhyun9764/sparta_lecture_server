package com.sparta.sparta_lecture_server.service.course;

import com.sparta.sparta_lecture_server.dto.course.response.CourseCategoryResponseDto;
import com.sparta.sparta_lecture_server.dto.course.request.CourseRequestDto;
import com.sparta.sparta_lecture_server.dto.course.response.CourseInstructorResponseDto;
import com.sparta.sparta_lecture_server.entity.course.Category;

import java.util.List;

public interface CourseService {

    // 강의 등록
    CourseInstructorResponseDto save(CourseRequestDto courseRequestDto);
    //선택한 강의 조회
    CourseInstructorResponseDto findById(Long courseId);
    //카테고리 별로 조회
    List<CourseCategoryResponseDto> findByCategory(Category category, String sortBy, boolean isAsc);
}
