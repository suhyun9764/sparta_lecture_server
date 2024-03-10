package com.sparta.sparta_lecture_server.service;

import com.sparta.sparta_lecture_server.dto.course.CourseRequestDto;
import com.sparta.sparta_lecture_server.dto.course.CourseResponseDto;

public interface CourseService {

    CourseResponseDto save(CourseRequestDto courseRequestDto);

    CourseResponseDto findById(Long courseId);
}
