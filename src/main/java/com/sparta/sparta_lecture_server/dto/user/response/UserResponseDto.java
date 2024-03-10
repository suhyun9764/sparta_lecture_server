package com.sparta.sparta_lecture_server.dto.user.response;

import com.sparta.sparta_lecture_server.entity.User.enums.GenderEnum;
import com.sparta.sparta_lecture_server.entity.User.enums.RoleEnum;
import com.sparta.sparta_lecture_server.entity.User.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long id;
    private String email;
    private GenderEnum genderEnum;
    private String phone;
    private String address;
    private RoleEnum roleEnum;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.genderEnum = user.getGenderEnum();
        this.phone = user.getPhone();
        this.address = user.getAddress();
        this.roleEnum = user.getRoleEnum();
    }
}
