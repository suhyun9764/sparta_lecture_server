package com.sparta.sparta_lecture_server.dto.comment;

import com.sparta.sparta_lecture_server.entity.comment.Comment;
import lombok.Getter;

@Getter

public class CommentResponseDto {
    private String content;

    public CommentResponseDto(Comment comment) {
        this.content = comment.getContent();
    }
}
