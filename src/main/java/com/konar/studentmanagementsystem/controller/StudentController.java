package com.konar.studentmanagementsystem.controller;

import com.konar.studentmanagementsystem.entity.Student;
import com.konar.studentmanagementsystem.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    private AppService appService;

    @Autowired
    StudentController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/home")
    public String showHome(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Student student = appService.findStudentByRegister(currentPrincipalName);
        model.addAttribute("student", student);
        return "student-home-page";
    }


}
