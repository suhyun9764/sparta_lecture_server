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
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;
    private final CourseRepository courseRepository;
    @Override
    @Transactional
    public CommentResponseDto save(Long courseId, CommentRequestDto commentRequestDto, User user) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new NullPointerException("해당하는 강의가 없습니다"));
        Comment comment = commentRepository.save(new Comment(user, course, commentRequestDto));
        return new CommentResponseDto(comment);
    }

    @Override
    @Transactional
    public CommentResponseDto update(Long courseId, Long commentId, CommentRequestDto commentRequestDto, User user) {
        if(!courseRepository.existsById(courseId)){
            throw new NullPointerException("해당하는 강의가 없습니다");
        }
        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
                new NullPointerException("해당하는 댓글이 없습니다"));

        System.out.println(user);
        System.out.println(comment.getUser());

        if(comment.getUser().getId()==user.getId()) {
            comment.update(commentRequestDto);
            return new CommentResponseDto(comment);
        }

        throw new IllegalArgumentException("댓글 작성자만 수정가능합니다");
    }

    @Transactional
    @Override
    public void delete(Long courseId, Long commentId, User user) {
        if(!courseRepository.existsById(courseId)){
            throw new NullPointerException("해당하는 강의가 없습니다");
        }

        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
                new NullPointerException("해당하는 댓글이 없습니다"));

        if(comment.getUser().getId()!=user.getId())
            throw new IllegalArgumentException("댓글 작성자만 수정가능합니다");

        commentRepository.delete(comment);
    }

    @Override
    public List<CommentResponseDto> commentToComment(Long courseId, Long parentId, CommentRequestDto commentRequestDto, User user) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new NullPointerException("해당하는 강의가 없습니다"));
        Comment parent = commentRepository.findById(parentId).orElseThrow(() ->
                new NullPointerException("해당하는 댓글이 없습니다"));
        commentRequestDto.setParentId(parentId);
        commentRepository.save(new Comment(user,course,commentRequestDto));
        return commentRepository.findAllByParentId(parentId).stream().map(CommentResponseDto::new).toList();
    }
}
