package com.sparta.sparta_lecture_server.service.like;

import com.sparta.sparta_lecture_server.entity.User.User;
import com.sparta.sparta_lecture_server.entity.course.Course;
import com.sparta.sparta_lecture_server.entity.like.Like;
import com.sparta.sparta_lecture_server.repository.CourseRepository;
import com.sparta.sparta_lecture_server.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.sparta.sparta_lecture_server.constants.course.Messages.NOT_FOUND_COURSE;
import static com.sparta.sparta_lecture_server.constants.like.messages.LIKE_CANCEL;
import static com.sparta.sparta_lecture_server.constants.like.messages.LIKE_SAVE;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService{
    private final LikeRepository likeRepository;
    private final CourseRepository courseRepository;
    @Transactional
    @Override
    public String pressLikeButton(Long courseId, User user) {
        Course course = getCourse(courseId);
        Optional<Like> like = likeRepository.findByCourseAndUser(course, user);
        if(like.isPresent()) {
            likeRepository.delete(like.get());
            return LIKE_CANCEL;
        }
        likeRepository.save(new Like(course,user));
        return LIKE_SAVE;
    }

    private Course getCourse(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() ->
                new NullPointerException(NOT_FOUND_COURSE));
        return course;
    }
}
