package com.tophyuk.dateRecord.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateRecordController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

}
