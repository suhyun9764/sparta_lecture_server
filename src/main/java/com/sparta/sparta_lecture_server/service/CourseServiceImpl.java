package com.sparta.sparta_lecture_server.service;

import com.sparta.sparta_lecture_server.dto.course.CourseRequestDto;
import com.sparta.sparta_lecture_server.dto.course.CourseResponseDto;
import com.sparta.sparta_lecture_server.entity.Instructor.Instructor;
import com.sparta.sparta_lecture_server.entity.course.Course;
import com.sparta.sparta_lecture_server.repository.CourseRepository;
import com.sparta.sparta_lecture_server.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    @Override
    public CourseResponseDto save(CourseRequestDto courseRequestDto) {
        Instructor instructor = instructorRepository.findById(courseRequestDto.getInstructor_id()).orElseThrow(() ->
                new NullPointerException("해당하는 강사가 존재하지 않습니다"));

        Course course = courseRepository.save(new Course(courseRequestDto, instructor));
        return new CourseResponseDto(course);
    }

    @Override
    public CourseResponseDto findById(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new NullPointerException("해당하는 강의가 존재하지 않습니다"));
        return new CourseResponseDto(course);
    }
}
