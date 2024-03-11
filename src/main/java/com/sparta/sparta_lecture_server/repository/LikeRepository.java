package com.sparta.sparta_lecture_server.repository;

import com.sparta.sparta_lecture_server.entity.User.User;
import com.sparta.sparta_lecture_server.entity.course.Course;
import com.sparta.sparta_lecture_server.entity.like.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like,Long> {
    Optional<Like> findByCourseAndUser(Course course, User user);
}
