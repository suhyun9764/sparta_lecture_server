package com.sparta.sparta_lecture_server.controller;

import com.sparta.sparta_lecture_server.dto.instructor.request.InstructorRequestDto;
import com.sparta.sparta_lecture_server.dto.instructor.response.InstructorResponseDto;
import com.sparta.sparta_lecture_server.security.UserDetailsImpl;
import com.sparta.sparta_lecture_server.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sparta.sparta_lecture_server.entity.User.enums.RoleEnum.Authority.ADMIN;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    @PostMapping
    @Secured(ADMIN)
    public ResponseEntity<InstructorResponseDto> save(@RequestBody InstructorRequestDto requestDto,
                                                      @AuthenticationPrincipal UserDetailsImpl userDetails){
        System.out.println("come");
        return ResponseEntity.ok(instructorService.save(requestDto,userDetails.getUser().getRoleEnum()));
    }
}
