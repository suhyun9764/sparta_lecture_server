package com.sparta.sparta_lecture_server.service.instructor;

import com.sparta.sparta_lecture_server.dto.instructor.request.InstructorRequestDto;
import com.sparta.sparta_lecture_server.dto.instructor.response.InstructorResponseDto;
import com.sparta.sparta_lecture_server.entity.Instructor.Instructor;
import com.sparta.sparta_lecture_server.entity.User.enums.RoleEnum;
import com.sparta.sparta_lecture_server.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    //강사 등록
    @Override
    public InstructorResponseDto save(InstructorRequestDto requestDto, RoleEnum roleEnum) {
        return new InstructorResponseDto(instructorRepository.save(new Instructor(requestDto)));
    }
}
