package com.sparta.sparta_lecture_server.service.like;

import com.sparta.sparta_lecture_server.entity.User.User;

public interface LikeService {
    //좋아요
    String pressLikeButton(Long courseId, User user);
}
