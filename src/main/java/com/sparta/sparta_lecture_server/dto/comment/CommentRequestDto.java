package com.sparta.sparta_lecture_server.dto.comment;

import com.sparta.sparta_lecture_server.entity.User.User;
import com.sparta.sparta_lecture_server.entity.course.Course;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentRequestDto {
    private String content;
    private Long parentId = 0L;
}
