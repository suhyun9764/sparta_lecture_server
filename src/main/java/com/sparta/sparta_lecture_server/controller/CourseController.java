package com.sparta.sparta_lecture_server.controller;

import com.sparta.sparta_lecture_server.dto.course.response.CourseCategoryResponseDto;
import com.sparta.sparta_lecture_server.dto.course.request.CourseRequestDto;
import com.sparta.sparta_lecture_server.dto.course.response.CourseInstructorResponseDto;
import com.sparta.sparta_lecture_server.entity.course.Category;
import com.sparta.sparta_lecture_server.service.course.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sparta.sparta_lecture_server.entity.User.enums.RoleEnum.Authority.ADMIN;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;
    // 강의 등록
    @PostMapping
    @Secured(ADMIN)
    public ResponseEntity<CourseInstructorResponseDto> save(@RequestBody CourseRequestDto courseRequestDto){
        return ResponseEntity.ok(courseService.save(courseRequestDto));
    }

    @GetMapping("/{course_id}")
    public ResponseEntity<CourseInstructorResponseDto> findById(@PathVariable Long course_id ){
        return ResponseEntity.ok(courseService.findById(course_id));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<CourseCategoryResponseDto>> findByCategory(@PathVariable @Valid Category category, @RequestParam("sortBy") String sortBy,
                                                                          @RequestParam("isAsc") boolean isAsc ){
        return ResponseEntity.ok(courseService.findByCategory(category,sortBy,isAsc));
    }
}
