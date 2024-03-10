package com.sparta.sparta_lecture_server.service;

import com.sparta.sparta_lecture_server.dto.SignUpRequestDto;
import com.sparta.sparta_lecture_server.dto.UserResponseDto;
import jakarta.validation.Valid;

public interface UserService {
    UserResponseDto signUp( SignUpRequestDto signUpRequestDto);
}
