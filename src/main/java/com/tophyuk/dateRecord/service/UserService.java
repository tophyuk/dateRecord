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

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //사용자 전체 조회
    public List<User> getList() {
        return userRepository.findAll();
    }

    //사용자 등록
    public void save(User user) {

        //todo - 중복확인

        userRepository.save(user);
    }



}
