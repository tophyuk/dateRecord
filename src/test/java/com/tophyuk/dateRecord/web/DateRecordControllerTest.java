package com.tophyuk.dateRecord.web;

import com.tophyuk.dateRecord.domain.User;
import com.tophyuk.dateRecord.repository.UserRepository;
import com.tophyuk.dateRecord.service.UserService;
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
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setRegion(region);
        user.setPassword(password);

        userService.save(user);

        //then
        //User resultUser = userRepository.findByEmail(email);
        //Assertions.assertThat(resultUser.getEmail()).isEqualTo(user.getEmail());

    }
}