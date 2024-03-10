package com.sparta.sparta_lecture_server.controller;

import com.sparta.sparta_lecture_server.service.UserService;
import com.sparta.sparta_lecture_server.dto.SignUpRequestDto;
import com.sparta.sparta_lecture_server.dto.UserResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signUp(@RequestBody @Valid SignUpRequestDto signUpRequestDto){
        UserResponseDto responseDto = userService.signUp(signUpRequestDto);
        return ResponseEntity.ok(responseDto);
    }

}
