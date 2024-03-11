package com.sparta.sparta_lecture_server.service;

import com.sparta.sparta_lecture_server.dto.user.request.SignUpRequestDto;
import com.sparta.sparta_lecture_server.dto.user.response.UserResponseDto;
import com.sparta.sparta_lecture_server.entity.User.enums.RoleEnum;
import com.sparta.sparta_lecture_server.entity.User.User;
import com.sparta.sparta_lecture_server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";

    @Override
    public UserResponseDto signUp(SignUpRequestDto signUpRequestDto) {
        Optional<User> user = userRepository.findByEmail(signUpRequestDto.getEmail());
        if(user.isPresent()){
            throw new IllegalArgumentException("중복된 이메일 입니다");
        }

        if(signUpRequestDto.isAdmin()){
            if(signUpRequestDto.getAdminToken()==ADMIN_TOKEN)
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다");

            signUpRequestDto.setRoleEnum(RoleEnum.ADMIN);
        }

        String encodePwd = passwordEncoder.encode(signUpRequestDto.getPassword());
        signUpRequestDto.setPassword(encodePwd);

        User saveUser = userRepository.save(new User(signUpRequestDto));

        return new UserResponseDto(saveUser);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
