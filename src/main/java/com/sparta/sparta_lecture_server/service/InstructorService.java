package com.sparta.sparta_lecture_server.service;

import com.sparta.sparta_lecture_server.dto.instructor.request.InstructorRequestDto;
import com.sparta.sparta_lecture_server.dto.instructor.response.InstructorResponseDto;
import com.sparta.sparta_lecture_server.entity.User.enums.RoleEnum;

public interface InstructorService {
    InstructorResponseDto save(InstructorRequestDto requestDto, RoleEnum roleEnum);
}
