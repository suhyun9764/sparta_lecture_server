package com.sparta.sparta_lecture_server.dto;

import com.sparta.sparta_lecture_server.entity.Gender;
import com.sparta.sparta_lecture_server.entity.Role;
import com.sparta.sparta_lecture_server.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class UserResponseDto {
    private Long id;
    private String email;
    private Gender gender;
    private String phone;
    private String address;
    private Role role;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.gender = user.getGender();
        this.phone = user.getPhone();
        this.address = user.getAddress();
        this.role = user.getRole();
    }
}
