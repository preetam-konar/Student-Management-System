package com.konar.studentmanagementsystem.service;

import com.konar.studentmanagementsystem.entity.Department;
import com.konar.studentmanagementsystem.entity.Student;

import java.util.List;

public interface AppService {

    void saveStudent(Student student);

    Student findStudentById(int id);

    Student findStudentByRegister(String rn);

    void deleteStudentByRegister(String rn);

    void deleteStudentById(int id);

    void updateStudent(Student student);

    void saveDepartment(Department department);

    void deleteDepartmentById(int id);

    void updateDepartment(Department department);

    Department findDepartmentById(int id);

    List<Student> findAllStudents();

    List<Department> findAllDepartments();


}
