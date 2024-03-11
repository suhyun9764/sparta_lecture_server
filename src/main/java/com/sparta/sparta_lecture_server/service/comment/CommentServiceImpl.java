package com.sparta.sparta_lecture_server.service.comment;

import com.sparta.sparta_lecture_server.dto.comment.CommentRequestDto;
import com.sparta.sparta_lecture_server.dto.comment.CommentResponseDto;
import com.sparta.sparta_lecture_server.entity.User.User;
import com.sparta.sparta_lecture_server.entity.comment.Comment;
import com.sparta.sparta_lecture_server.entity.course.Course;
import com.sparta.sparta_lecture_server.repository.CommentRepository;
import com.sparta.sparta_lecture_server.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.sparta.sparta_lecture_server.constants.comment.messages.*;
import static com.sparta.sparta_lecture_server.constants.course.Messages.NOT_FOUND_COURSE;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;
    private final CourseRepository courseRepository;
    @Override
    @Transactional  // 댓글 등록
    public CommentResponseDto save(Long courseId, CommentRequestDto commentRequestDto, User user) {
        Course course = getCourse(courseId);
        Comment comment = commentRepository.save(new Comment(user, course, commentRequestDto));
        return new CommentResponseDto(comment);
    }

    @Override
    @Transactional  // 댓글 수정
    public CommentResponseDto update(Long courseId, Long commentId, CommentRequestDto commentRequestDto, User user) {
        checkCourseExist(courseId);
        Comment comment = getComment(commentId);

        if(comment.getUser().getId()==user.getId()) {
            comment.update(commentRequestDto);
            return new CommentResponseDto(comment);
        }

        throw new IllegalArgumentException(ONLY_WRITER_CAN_UPDATE);
    }


    @Transactional
    @Override   // 댓글 삭제
    public void delete(Long courseId, Long commentId, User user) {
        checkCourseExist(courseId);
        Comment comment = getComment(commentId);

        if(comment.getUser().getId()!=user.getId())
            throw new IllegalArgumentException(ONLY_WRITER_CAN_DELETE);

        commentRepository.delete(comment);
    }

    @Transactional
    @Override   // 대댓글 등록
    public List<CommentResponseDto> commentToComment(Long courseId, Long parentId, CommentRequestDto commentRequestDto, User user) {
        Course course = getCourse(courseId);
        getComment(parentId);
        commentRequestDto.setParentId(parentId);
        commentRepository.save(new Comment(user,course,commentRequestDto));
        return commentRepository.findAllByParentId(parentId).stream().map(CommentResponseDto::new).toList();
    }
    private Course getCourse(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new NullPointerException(NOT_FOUND_COURSE));
        return course;
    }

    private void checkCourseExist(Long courseId) {
        if(!courseRepository.existsById(courseId)){
            throw new NullPointerException(NOT_FOUND_COURSE);
        }
    }

    private Comment getComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
                new NullPointerException(NOT_FOUND_COMMENT));
        return comment;
    }

}
