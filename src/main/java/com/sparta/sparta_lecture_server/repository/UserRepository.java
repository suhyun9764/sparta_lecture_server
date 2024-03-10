package com.sparta.sparta_lecture_server.repository;

import com.sparta.sparta_lecture_server.entity.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);

}
