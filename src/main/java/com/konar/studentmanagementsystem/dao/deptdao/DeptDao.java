package com.konar.studentmanagementsystem.dao.deptdao;


import com.konar.studentmanagementsystem.entity.Department;

public interface DeptDao {

    void save(Department department);

    Department findById(int id);

    void deleteById(int id);

    void update(Department department);

}
