package com.konar.studentmanagementsystem.service;

import com.konar.studentmanagementsystem.dao.deptdao.DeptDao;
import com.konar.studentmanagementsystem.dao.securitydao.UserDao;
import com.konar.studentmanagementsystem.dao.studentdao.StudentDao;
import com.konar.studentmanagementsystem.entity.Department;
import com.konar.studentmanagementsystem.entity.Student;
import com.konar.studentmanagementsystem.entity.security.Role;
import com.konar.studentmanagementsystem.entity.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    private StudentDao studentDao;
    private DeptDao deptDao;
    private UserDao userDao;

    @Autowired
    AppServiceImpl(StudentDao studentDao, DeptDao deptDao, UserDao userDao) {
        this.studentDao = studentDao;
        this.deptDao = deptDao;
        this.userDao = userDao;
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

    @Override
    public void addUser(User user, Role role) {
        userDao.add(user, role);
    }

    @Override
    public void removeUser(User user) {
        userDao.remove(user);
    }

    @Override
    public void removeUserByUserId(String userId) {
        userDao.removeByUserId(userId);
    }

    @Override
    public User findUserByUserId(String userId) {
        return userDao.findByUserId(userId);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }
}
