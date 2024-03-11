package com.sparta.sparta_lecture_server.service.user;

import com.sparta.sparta_lecture_server.dto.user.request.SignUpRequestDto;
import com.sparta.sparta_lecture_server.dto.user.response.UserResponseDto;
import com.sparta.sparta_lecture_server.entity.User.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    //회원가입
    UserResponseDto signUp( SignUpRequestDto signUpRequestDto);

    //회원탈퇴
    void delete(User userDetails);


}
