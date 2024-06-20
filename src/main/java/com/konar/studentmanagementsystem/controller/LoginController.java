package com.konar.studentmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String loginPage() {
        // TODO: 18-06-2024 create login page
        return null;
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        // TODO: 18-06-2024 create access denied page
        return null;
    }
}
