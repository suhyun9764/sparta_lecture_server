package com.sparta.sparta_lecture_server.service;

import com.sparta.sparta_lecture_server.entity.User.User;
import com.sparta.sparta_lecture_server.entity.course.Course;
import com.sparta.sparta_lecture_server.entity.like.Like;
import com.sparta.sparta_lecture_server.repository.CourseRepository;
import com.sparta.sparta_lecture_server.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService{
    private final LikeRepository likeRepository;
    private final CourseRepository courseRepository;
    @Transactional
    @Override
    public String pressLikeButton(Long courseId, User user) {
        Course course = courseRepository.findById(courseId).orElseThrow(() ->
                new NullPointerException("해당하는 강의가 없습니다"));
        Optional<Like> like = likeRepository.findByCourseAndUser(course, user);
        if(like.isPresent()) {
            likeRepository.delete(like.get());
            return "좋아요 취소";
        }
        likeRepository.save(new Like(course,user));
        return "좋아요!";
    }
}
