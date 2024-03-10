package com.sparta.sparta_lecture_server.entity.Instructor;

import com.sparta.sparta_lecture_server.dto.instructor.request.InstructorRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "instructors")
@Getter
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int experience;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String intro;

    public Instructor(InstructorRequestDto requestDto) {
        this.name = requestDto.getName();
        this.experience = requestDto.getExperience();
        this.company = requestDto.getCompany();
        this.phone = requestDto.getPhone();
        this.intro = requestDto.getIntro();
    }
}
