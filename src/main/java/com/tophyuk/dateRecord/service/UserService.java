package com.tophyuk.dateRecord.service;

import com.tophyuk.dateRecord.domain.User;
import com.tophyuk.dateRecord.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    //사용자 전체 조회
    public List<User> getList() {
        return userRepository.findAll();
    }

    //사용자 등록
    public void save(User userForm) {
        // 사용자 등록
        User user = new User();
        log.info("userForm class={}", userForm);
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setRegion(userForm.getRegion());

        //todo - 중복확인

        //패스워드 암호화 후 적용
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));

        userRepository.save(user);
    }



}
