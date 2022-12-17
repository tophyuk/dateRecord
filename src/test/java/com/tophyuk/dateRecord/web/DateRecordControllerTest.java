package com.tophyuk.dateRecord.web;

import com.tophyuk.dateRecord.domain.User;
import com.tophyuk.dateRecord.repository.UserRepository;
import com.tophyuk.dateRecord.service.UserService;
import com.tophyuk.dateRecord.validation.form.SignupForm;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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
        String email = "sanghyuk199@naver.com";
        String region = "DAEGU";
        String password ="wjdtkdgur";

        //when
        SignupForm form = new SignupForm();
        form.setName(name);
        form.setEmail(email);
        form.setRegion(region);
        form.setPassword(password);

        userService.save(form);

        //then
        //User resultUser = userRepository.findByEmail(email);
        //Assertions.assertThat(resultUser.getEmail()).isEqualTo(user.getEmail());

    }
}