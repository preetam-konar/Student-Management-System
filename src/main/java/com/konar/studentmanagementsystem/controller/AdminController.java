package com.konar.studentmanagementsystem.controller;

import com.konar.studentmanagementsystem.entity.Department;
import com.konar.studentmanagementsystem.entity.Student;
import com.konar.studentmanagementsystem.service.AppService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private AppService appService;

    @Value("${semester}")
    private List<Integer> semList;

    AdminController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/home")
    public String showHome() {
        return "admin-home-page";
    }

    @GetMapping("/listStudents")
    public String listStudents(Model model) {

        List<Student> studentList = appService.findAllStudents();
        model.addAttribute("studentList", studentList);
        return "list-students-page";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") int studentId) {
        Student student = appService.findStudentById(studentId);
        appService.deleteStudentById(studentId);
        appService.removeUserByUserId(student.getRegisterNumber());
        return "redirect:/admin/listStudents";
    }

    @GetMapping("/updateStudent")
    public String updateStudent(@RequestParam("studentId") int studentId, Model model) {
        Student tempStudent = appService.findStudentById(studentId);

        List<Department> departmentList = appService.findAllDepartments();
        model.addAttribute("student", tempStudent);
        model.addAttribute("semList", semList);
        model.addAttribute("deptList", departmentList);

        return "student-form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student, @RequestParam("dept") int deptId) {

        Department department = appService.findDepartmentById(deptId);
        student.setDepartment(department);

        if (appService.findStudentById(student.getId()) != null) {
            appService.updateStudent(student);
        } else {
            appService.saveStudent(student);
        }
        return "redirect:/admin/listStudents";
    }


}
