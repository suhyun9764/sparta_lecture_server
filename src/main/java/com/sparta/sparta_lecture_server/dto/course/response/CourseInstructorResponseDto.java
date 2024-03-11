package com.sparta.sparta_lecture_server.dto.course.response;

import com.sparta.sparta_lecture_server.dto.comment.CommentResponseDto;
import com.sparta.sparta_lecture_server.dto.instructor.response.InstructorResponseDto;
import com.sparta.sparta_lecture_server.entity.comment.Comment;
import com.sparta.sparta_lecture_server.entity.course.Category;
import com.sparta.sparta_lecture_server.entity.course.Course;
import com.sparta.sparta_lecture_server.entity.like.Like;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class CourseInstructorResponseDto {
    private String title;

    private int price;

    private Category category;

    private String description;

    private InstructorResponseDto instructor;

    private LocalDate registerDate;

    private List<CommentResponseDto> comments;

    private int likeNum;

    public CourseInstructorResponseDto(Course course) {
        this.title = course.getTitle();
        this.price = course.getPrice();
        this.category = course.getCategory();
        this.description = course.getDescription();
        this.instructor = new InstructorResponseDto(course.getInstructor());
        this.registerDate = course.getRegisterDate();
        this.comments = course.getCommentList().stream().map(CommentResponseDto::new).toList();
        this.likeNum = course.getLikeList().size();
    }

}
