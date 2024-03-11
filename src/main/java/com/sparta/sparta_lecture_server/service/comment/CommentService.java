package com.sparta.sparta_lecture_server.service.comment;

import com.sparta.sparta_lecture_server.dto.comment.CommentRequestDto;
import com.sparta.sparta_lecture_server.dto.comment.CommentResponseDto;
import com.sparta.sparta_lecture_server.entity.User.User;

import java.util.List;

public interface CommentService {
    // 댓글 등록
    CommentResponseDto save(Long courseId, CommentRequestDto commentRequestDto, User user);

    CommentResponseDto update(Long courseId, Long commentId, CommentRequestDto commentRequestDto, User user);
    //댓글 삭제
    void delete(Long courseId, Long commentId, User user);

    List<CommentResponseDto> commentToComment(Long courseId, Long parentId, CommentRequestDto commentRequestDto, User user);
}
