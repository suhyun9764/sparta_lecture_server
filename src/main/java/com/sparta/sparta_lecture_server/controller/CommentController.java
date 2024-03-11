package com.sparta.sparta_lecture_server.controller;

import com.sparta.sparta_lecture_server.dto.comment.CommentRequestDto;
import com.sparta.sparta_lecture_server.dto.comment.CommentResponseDto;
import com.sparta.sparta_lecture_server.security.UserDetailsImpl;
import com.sparta.sparta_lecture_server.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses/{courseId}/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponseDto> save(@PathVariable Long courseId, @RequestBody CommentRequestDto commentRequestDto,
                                                   @AuthenticationPrincipal UserDetailsImpl userDetails){
        return ResponseEntity.ok(commentService.save(courseId,commentRequestDto,userDetails.getUser()));
    }

    @PutMapping("/{commentId}")

    public ResponseEntity<CommentResponseDto> update(@PathVariable Long courseId, @PathVariable Long commentId,
                                                     @RequestBody CommentRequestDto commentRequestDto,
                                                     @AuthenticationPrincipal UserDetailsImpl userDetails){
        return ResponseEntity.ok(commentService.update(courseId,commentId,commentRequestDto,userDetails.getUser()));
    }
}
