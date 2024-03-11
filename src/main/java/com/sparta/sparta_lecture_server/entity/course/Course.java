package com.sparta.sparta_lecture_server.entity.course;

import com.sparta.sparta_lecture_server.dto.course.CourseRequestDto;
import com.sparta.sparta_lecture_server.entity.Comment;
import com.sparta.sparta_lecture_server.entity.Instructor.Instructor;
import com.sparta.sparta_lecture_server.entity.like.Like;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@NoArgsConstructor
public class Course extends DateValue{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "course")
    private List<Comment> orderList = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<Like> likeList = new ArrayList<>();

    public Course(CourseRequestDto courseRequestDto,Instructor instructor) {
        this.title = courseRequestDto.getTitle();
        this.price = courseRequestDto.getPrice();
        this.category = courseRequestDto.getCategory();
        this.description = courseRequestDto.getDescription();
        this.instructor = instructor;
    }
}
