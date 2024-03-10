package com.sparta.sparta_lecture_server.dto.comment;

import com.sparta.sparta_lecture_server.entity.Comment;
import com.sparta.sparta_lecture_server.entity.User.User;
import com.sparta.sparta_lecture_server.entity.course.Course;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter

public class CommentResponseDto {
    private String content;

    public CommentResponseDto(Comment comment) {
        this.content = comment.getContent();
    }
}
