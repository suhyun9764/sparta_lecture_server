package com.sparta.sparta_lecture_server.service.instructor;

import com.sparta.sparta_lecture_server.dto.instructor.request.InstructorRequestDto;
import com.sparta.sparta_lecture_server.dto.instructor.response.InstructorResponseDto;
import com.sparta.sparta_lecture_server.entity.User.enums.RoleEnum;

public interface InstructorService {
    //강사 등록
    InstructorResponseDto save(InstructorRequestDto requestDto, RoleEnum roleEnum);
}
