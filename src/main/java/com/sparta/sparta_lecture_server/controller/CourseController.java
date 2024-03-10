package com.sparta.sparta_lecture_server.controller;

import com.sparta.sparta_lecture_server.dto.course.CourseRequestDto;
import com.sparta.sparta_lecture_server.dto.course.CourseResponseDto;
import com.sparta.sparta_lecture_server.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import static com.sparta.sparta_lecture_server.entity.User.enums.RoleEnum.Authority.ADMIN;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;
    @PostMapping
    @Secured(ADMIN)
    public ResponseEntity<CourseResponseDto> save(@RequestBody CourseRequestDto courseRequestDto){
        return ResponseEntity.ok(courseService.save(courseRequestDto));
    }

    @GetMapping("/{course_id}")
    public ResponseEntity<CourseResponseDto> findById(@PathVariable Long course_id ){
        return ResponseEntity.ok(courseService.findById(course_id));
    }
}
