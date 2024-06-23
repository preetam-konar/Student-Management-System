package com.konar.studentmanagementsystem.dao.deptdao;


import com.konar.studentmanagementsystem.entity.Department;

import java.util.List;

public interface DeptDao {

    void save(Department department);

    Department findById(int id);

    void deleteById(int id);

    void update(Department department);

    List<Department> findAll();

}
