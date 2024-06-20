package com.konar.studentmanagementsystem.dao.studentdao;

import com.konar.studentmanagementsystem.entity.Student;

public interface StudentDao {

    void save(Student student);

    Student findById(int id);

    Student findByRegister(String rn);

    void deleteByRegister(String rn);

    void deleteById(int id);

    void update(Student student);

}
