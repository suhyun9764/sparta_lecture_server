package com.sparta.sparta_lecture_server.service.course;

import com.sparta.sparta_lecture_server.dto.course.request.CourseRequestDto;
import com.sparta.sparta_lecture_server.dto.course.response.CourseCategoryResponseDto;
import com.sparta.sparta_lecture_server.dto.course.response.CourseInstructorResponseDto;
import com.sparta.sparta_lecture_server.entity.Instructor.Instructor;
import com.sparta.sparta_lecture_server.entity.course.Category;
import com.sparta.sparta_lecture_server.entity.course.Course;
import com.sparta.sparta_lecture_server.repository.CourseRepository;
import com.sparta.sparta_lecture_server.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.sparta.sparta_lecture_server.constants.course.Messages.NOT_FOUND_COURSE;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;


    @Override // 강의 등록
    public CourseInstructorResponseDto save(CourseRequestDto courseRequestDto) {
        Instructor instructor = getInstructor(courseRequestDto);
        Course course = courseRepository.save(new Course(courseRequestDto, instructor));
        return new CourseInstructorResponseDto(course);
    }

    @Override // 선택한 강의 조회
    public CourseInstructorResponseDto findById(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new NullPointerException(NOT_FOUND_COURSE));
        return new CourseInstructorResponseDto(course);
    }

    @Override
    public List<CourseCategoryResponseDto> findByCategory(Category category, String sortBy, boolean isAsc) {
        if ("title".equals(sortBy) || "registerDate".equals(sortBy) || "price".equals(sortBy)) {
            Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
            Sort sort = Sort.by(direction, sortBy);
            List<CourseCategoryResponseDto> list = courseRepository.findByCategory(category, sort).stream().map(CourseCategoryResponseDto::new).toList();
            return list;

        }

        throw new IllegalArgumentException("정렬 기준이 잘못되었습니다");

    }

    private Instructor getInstructor(CourseRequestDto courseRequestDto) {
        Instructor instructor = instructorRepository.findById(courseRequestDto.getInstructor_id()).orElseThrow(() ->
                new NullPointerException("해당하는 강사가 존재하지 않습니다"));
        return instructor;
    }

}
