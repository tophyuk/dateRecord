package com.tophyuk.dateRecord.service;

import com.tophyuk.dateRecord.domain.User;
import com.tophyuk.dateRecord.repository.UserRepository;
import com.tophyuk.dateRecord.validation.form.SignupForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
    public void save(SignupForm signupForm) {
        // 사용자 등록
        User user = new User();
        log.info("userForm class={}", signupForm);
        user.setName(signupForm.getName());
        user.setEmail(signupForm.getEmail());
        user.setRegion(signupForm.getRegion());

        //패스워드 암호화 후 적용
        user.setPassword(passwordEncoder.encode(signupForm.getPassword()));

        userRepository.save(user);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }



}
