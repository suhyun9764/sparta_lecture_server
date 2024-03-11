package com.sparta.sparta_lecture_server.entity;

import com.sparta.sparta_lecture_server.dto.comment.CommentRequestDto;
import com.sparta.sparta_lecture_server.entity.User.User;
import com.sparta.sparta_lecture_server.entity.course.Course;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comments")
@Getter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String content;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name ="course_id")
    private Course course;

    @Column
    private Long parentId = 0L;

    public Comment(User user, Course course, CommentRequestDto commentRequestDto) {
        this.user = user;
        this.course = course;
        this.content = commentRequestDto.getContent();
        this.parentId = commentRequestDto.getParentId();
    }

    public void update(CommentRequestDto commentRequestDto) {
        this.content = commentRequestDto.getContent();
    }
}
