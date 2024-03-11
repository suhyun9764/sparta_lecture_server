package com.sparta.sparta_lecture_server.controller;

import com.sparta.sparta_lecture_server.security.UserDetailsImpl;
import com.sparta.sparta_lecture_server.service.user.UserService;
import com.sparta.sparta_lecture_server.dto.user.request.SignUpRequestDto;
import com.sparta.sparta_lecture_server.dto.user.response.UserResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sparta.sparta_lecture_server.constants.user.Messages.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/login-page")
    public String customLoginPage() {
        return PLEASE_LOGIN;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signUp(@RequestBody @Valid SignUpRequestDto signUpRequestDto,
                                                  BindingResult bindingResult){
        checkInputFormat(bindingResult);
        UserResponseDto responseDto = userService.signUp(signUpRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@AuthenticationPrincipal UserDetailsImpl userDetails){
        userService.delete(userDetails.getUser());
        return ResponseEntity.ok(DELETE_COMPLETE);
    }

    private static void checkInputFormat(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if(fieldErrors.size()>0){
            String errorField = fieldErrors.stream().findFirst().get().getField();
            String message = String.format(WRONG_INPUT_FORMAT, errorField);
            throw new IllegalArgumentException(message);
        }
    }

}
