package com.sparta.sparta_lecture_server.service;

import com.sparta.sparta_lecture_server.dto.user.request.SignUpRequestDto;
import com.sparta.sparta_lecture_server.dto.user.response.UserResponseDto;
import com.sparta.sparta_lecture_server.entity.User.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    @Transactional
    UserResponseDto signUp( SignUpRequestDto signUpRequestDto);

    void delete(User userDetails);


}
