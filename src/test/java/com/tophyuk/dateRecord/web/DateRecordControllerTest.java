package com.tophyuk.dateRecord.web;

import com.tophyuk.dateRecord.domain.User;
import com.tophyuk.dateRecord.repository.UserRepository;
import com.tophyuk.dateRecord.service.UserService;
import com.tophyuk.dateRecord.validation.form.SignupForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DateRecordControllerTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test()
    void signup() {

        //given
        String name ="상혁";
        String email = "sanghyuk1992@naver.com";
        String region = "DAEGU";
        String password ="wjdtkdgur";

        //when
        SignupForm form = new SignupForm();
        form.setName(name);
        form.setEmail(email);
        form.setRegion(region);
        form.setPassword(password);

        //회원가입
        userService.save(form);

        //then
        //User resultUser = userRepository.findByEmail(email);
        //Assertions.assertThat(resultUser.getEmail()).isEqualTo(user.getEmail());

    }

    @Test
    void emailOverlapCheck() {

        String email ="sanghyuk992@naver.com";

        Optional<User> byEmail = userService.findByEmail(email);
        assertTrue(byEmail.isPresent());

    }
}