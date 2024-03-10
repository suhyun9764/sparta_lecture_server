package com.sparta.sparta_lecture_server.service;

import com.sparta.sparta_lecture_server.entity.User.User;
import com.sparta.sparta_lecture_server.repository.CommentRepository;
import com.sparta.sparta_lecture_server.dto.comment.CommentRequestDto;
import com.sparta.sparta_lecture_server.dto.comment.CommentResponseDto;
import com.sparta.sparta_lecture_server.entity.Comment;
import com.sparta.sparta_lecture_server.entity.course.Course;
import com.sparta.sparta_lecture_server.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;
    private final CourseRepository courseRepository;
    @Override
    public CommentResponseDto save(Long courseId, CommentRequestDto commentRequestDto, User user) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new NullPointerException("해당하는 강의가 없습니다"));
        Comment comment = commentRepository.save(new Comment(user, course, commentRequestDto));
        return new CommentResponseDto(comment);
    }
}
