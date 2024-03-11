package com.sparta.sparta_lecture_server.service;

import com.sparta.sparta_lecture_server.entity.User.User;

public interface LikeService {
    String pressLikeButton(Long courseId, User user);
}
