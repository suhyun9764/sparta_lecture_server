package com.sparta.sparta_lecture_server.repository;

import com.sparta.sparta_lecture_server.entity.Instructor.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Long> {
}
