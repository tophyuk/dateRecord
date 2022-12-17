package com.tophyuk.dateRecord.web;

import com.tophyuk.dateRecord.domain.User;
import com.tophyuk.dateRecord.service.UserService;
import com.tophyuk.dateRecord.validation.form.SignupForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@Slf4j
@RequiredArgsConstructor
public class DateRecordController {

    private final UserService userService;

    @ModelAttribute("regions")
    public Map<String, String> regions() {
        Map<String, String> regions = new LinkedHashMap<>();
        regions.put("SEOUL", "서울");
        regions.put("BUSAN", "부산");
        regions.put("JEJU", "제주");
        regions.put("DAEGU", "대구");

        return regions;
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("signupForm", new SignupForm());
        return "/form/signup";
    }

    @PostMapping("/signup")
    public String signupUser(@Validated SignupForm form ,BindingResult bindingResult) throws Exception {
        log.info("form={}", form);


        // binding 에러
        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "/form/signup";
        }

        // 비밀번호, 비밀번호 확인이 같은지 확인
        if (!form.getPassword().equals(form.getPassword2())) {
            bindingResult.rejectValue("password", "passwordUnmatched",
                    "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            return "/form/signup";
        }

        // 정상 로직
        userService.save(form);

        return "redirect:/";
    }

}
