package com.sparta.sparta_lecture_server.repository;

import com.sparta.sparta_lecture_server.entity.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
