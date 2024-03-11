package com.sparta.sparta_lecture_server.controller;

import com.sparta.sparta_lecture_server.dto.comment.CommentRequestDto;
import com.sparta.sparta_lecture_server.dto.comment.CommentResponseDto;
import com.sparta.sparta_lecture_server.security.UserDetailsImpl;
import com.sparta.sparta_lecture_server.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sparta.sparta_lecture_server.constants.comment.messages.DELETE_COMPLETE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses/{courseId}/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping //댓글 등록
    public ResponseEntity<CommentResponseDto> save(@PathVariable Long courseId, @RequestBody CommentRequestDto commentRequestDto,
                                                   @AuthenticationPrincipal UserDetailsImpl userDetails){
        return ResponseEntity.ok(commentService.save(courseId,commentRequestDto,userDetails.getUser()));
    }

    @PutMapping("/{commentId}") //댓글 수정
    public ResponseEntity<CommentResponseDto> update(@PathVariable Long courseId, @PathVariable Long commentId,
                                                     @RequestBody CommentRequestDto commentRequestDto,
                                                     @AuthenticationPrincipal UserDetailsImpl userDetails){
        return ResponseEntity.ok(commentService.update(courseId,commentId,commentRequestDto,userDetails.getUser()));
    }

    @DeleteMapping("/{commentId}") //댓글 삭제


    public ResponseEntity<String> delete(@PathVariable Long courseId, @PathVariable Long commentId,
                                                     @AuthenticationPrincipal UserDetailsImpl userDetails){
        commentService.delete(courseId,commentId,userDetails.getUser());
        return ResponseEntity.ok(DELETE_COMPLETE);
    }

    @PostMapping("/{parentId}/replies") //대댓글

    public ResponseEntity<List<CommentResponseDto>> commentToComment(@PathVariable Long courseId, @PathVariable Long parentId,
                                                          @RequestBody CommentRequestDto commentRequestDto,
                                                          @AuthenticationPrincipal UserDetailsImpl userDetails){
        List<CommentResponseDto> commentResponseDtoList =
                commentService.commentToComment(courseId,parentId,commentRequestDto,userDetails.getUser());
        return ResponseEntity.ok(commentResponseDtoList);
    }
}
