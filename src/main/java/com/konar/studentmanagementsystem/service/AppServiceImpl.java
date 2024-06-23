package com.konar.studentmanagementsystem.service;

import com.konar.studentmanagementsystem.dao.deptdao.DeptDao;
import com.konar.studentmanagementsystem.dao.studentdao.StudentDao;
import com.konar.studentmanagementsystem.entity.Department;
import com.konar.studentmanagementsystem.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    private StudentDao studentDao;
    private DeptDao deptDao;

    @Autowired
    AppServiceImpl(StudentDao studentDao, DeptDao deptDao) {
        this.studentDao = studentDao;
        this.deptDao = deptDao;
    }

    @Override
    public void saveStudent(Student student) {
        studentDao.save(student);
    }

    @Override
    public Student findStudentById(int id) {
        return studentDao.findById(id);
    }

    @Override
    public Student findStudentByRegister(String rn) {
        return studentDao.findByRegister(rn);
    }

    @Override
    public void deleteStudentByRegister(String rn) {
        studentDao.deleteByRegister(rn);
    }

    @Override
    public void deleteStudentById(int id) {
        studentDao.deleteById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.update(student);
    }

    @Override
    public void saveDepartment(Department department) {
        deptDao.save(department);
    }

    @Override
    public void deleteDepartmentById(int id) {
        deptDao.deleteById(id);
    }

    @Override
    public void updateDepartment(Department department) {
        deptDao.update(department);
    }

    @Override
    public Department findDepartmentById(int id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public List<Department> findAllDepartments() {
        return deptDao.findAll();
    }
}
