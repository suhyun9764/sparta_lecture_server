package com.sparta.sparta_lecture_server.dto.instructor.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class InstructorRequestDto {
    @NotBlank
    private String name;

    @NotBlank
    private int experience;

    @NotBlank
    private String company;

    @NotBlank
    private String phone;

    @NotBlank
    private String intro;

}
