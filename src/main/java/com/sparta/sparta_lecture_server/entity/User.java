package com.sparta.sparta_lecture_server.entity;

import com.sparta.sparta_lecture_server.dto.SignUpRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Role role;

    public User(SignUpRequestDto signUpRequestDto) {
        this.password = signUpRequestDto.getPassword();
        this.email = signUpRequestDto.getEmail();
        this.gender = signUpRequestDto.getGender();
        this.phone = signUpRequestDto.getPhone();
        this.address = signUpRequestDto.getAddress();
        this.role = signUpRequestDto.getRole();


    }
}
