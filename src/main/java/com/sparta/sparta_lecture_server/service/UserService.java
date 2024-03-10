package com.sparta.sparta_lecture_server.service;

import com.sparta.sparta_lecture_server.dto.user.request.SignUpRequestDto;
import com.sparta.sparta_lecture_server.dto.user.response.UserResponseDto;

public interface UserService {
    UserResponseDto signUp( SignUpRequestDto signUpRequestDto);
}
