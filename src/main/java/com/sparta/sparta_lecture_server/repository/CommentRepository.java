package com.sparta.sparta_lecture_server.repository;

import com.sparta.sparta_lecture_server.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByParentId(Long parentId);
}
