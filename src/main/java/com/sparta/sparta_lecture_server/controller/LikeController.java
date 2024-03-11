package com.sparta.sparta_lecture_server.controller;

import com.sparta.sparta_lecture_server.security.UserDetailsImpl;
import com.sparta.sparta_lecture_server.service.like.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses/{courseId}/like")
public class LikeController {
    private final LikeService likeService;
    @PostMapping
    public ResponseEntity<String> pressLikeButton(@PathVariable Long courseId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return ResponseEntity.ok(likeService.pressLikeButton(courseId,userDetails.getUser()));
    }
}
