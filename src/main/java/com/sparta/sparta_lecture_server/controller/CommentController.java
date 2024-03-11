package com.sparta.sparta_lecture_server.controller;

import com.sparta.sparta_lecture_server.dto.comment.CommentRequestDto;
import com.sparta.sparta_lecture_server.dto.comment.CommentResponseDto;
import com.sparta.sparta_lecture_server.entity.Comment;
import com.sparta.sparta_lecture_server.security.UserDetailsImpl;
import com.sparta.sparta_lecture_server.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/{commentId}")

    public ResponseEntity<String> delete(@PathVariable Long courseId, @PathVariable Long commentId,
                                                     @AuthenticationPrincipal UserDetailsImpl userDetails){
        commentService.delete(courseId,commentId,userDetails.getUser());
        return ResponseEntity.ok("댓글 삭제가 완료되었습니다");
    }

    @PostMapping("/{parentId}/replies")

    public ResponseEntity<List<CommentResponseDto>> commentToComment(@PathVariable Long courseId, @PathVariable Long parentId,
                                                          @RequestBody CommentRequestDto commentRequestDto,
                                                          @AuthenticationPrincipal UserDetailsImpl userDetails){
        List<CommentResponseDto> commentResponseDtoList =
                commentService.commentToComment(courseId,parentId,commentRequestDto,userDetails.getUser());
        return ResponseEntity.ok(commentResponseDtoList);
    }
}
