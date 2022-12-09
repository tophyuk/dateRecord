package com.tophyuk.dateRecord.web;

import com.tophyuk.dateRecord.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@Slf4j
public class DateRecordController {

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
        model.addAttribute("user", new User());
        return "/form/signup";
    }

    @PostMapping("/signup")
    public String signupUser(@ModelAttribute User user) {
        log.info("user.name={}", user.getName());
        log.info("user.regions={}", user.getRegions());
        log.info("user.email={}", user.getEmail());
        log.info("user.password={}", user.getPassword());

        return "redirect:/";
    }
}
