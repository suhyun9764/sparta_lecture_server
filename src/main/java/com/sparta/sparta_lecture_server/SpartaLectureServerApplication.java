package com.sparta.sparta_lecture_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpartaLectureServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpartaLectureServerApplication.class, args);
    }

}
