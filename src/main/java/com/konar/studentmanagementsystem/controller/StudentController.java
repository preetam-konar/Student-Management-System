package com.konar.studentmanagementsystem.controller;

import com.konar.studentmanagementsystem.entity.Student;
import com.konar.studentmanagementsystem.service.AppService;
import jakarta.annotation.PostConstruct;
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
    private Authentication authentication;
    private String currentPrincipalName;
    private Student currStudent;


    @Autowired
    StudentController(AppService appService) {
        this.appService = appService;
    }

    private void setStudent() {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        currentPrincipalName = authentication.getName();
        currStudent = appService.findStudentByRegister(currentPrincipalName);
    }


    @GetMapping("/home")
    public String showHome(Model model) {
        setStudent();
        model.addAttribute("student", currStudent);
        return "student-home-page";
    }


}
