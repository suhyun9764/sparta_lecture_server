package com.sparta.sparta_lecture_server.repository;

import com.sparta.sparta_lecture_server.entity.course.Category;
import com.sparta.sparta_lecture_server.entity.course.Course;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findByCategory(Category category, Sort sort);
}
