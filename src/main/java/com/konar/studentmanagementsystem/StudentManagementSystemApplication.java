package com.konar.studentmanagementsystem;

import com.konar.studentmanagementsystem.entity.Department;
import com.konar.studentmanagementsystem.entity.Student;
import com.konar.studentmanagementsystem.service.AppService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);
    }

    /*

    @Bean
    public CommandLineRunner commandLineRunner(AppService appService) {
        return runner -> {
            findDepartment(appService);
        };
    }

    private void findDepartment(AppService appService) {

        int id = 1;
        System.out.println("Finding department with id : " + id);
        Department department = appService.findDepartmentById(id);
        System.out.println(department);

    }

    private void createStudent(AppService appService) {
        Department department = Department.builder().id(1).deptName("CTECH").build();
        Student student = Student.builder()
                .firstName("John")
                .lastName("Doe")
                .age(20)
                .email("john@gmail.com")
                .collegeEmail("john@college.com")
                .gender("male")
                .semester(2)
                .registerNumber("RA2011003010041")
                .build();

        student.setDepartment(department);
        System.out.println("Saving...");
        appService.saveStudent(student);
        System.out.println("Saved!");
    }
     */

}
