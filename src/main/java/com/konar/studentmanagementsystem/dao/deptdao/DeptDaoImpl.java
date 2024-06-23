package com.konar.studentmanagementsystem.dao.deptdao;

import com.konar.studentmanagementsystem.entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DeptDaoImpl implements DeptDao {

    private EntityManager entityManager;

    @Autowired
    DeptDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Department department) {
        entityManager.persist(department);
    }

    @Override
    public Department findById(int id) {
        return entityManager.find(Department.class, id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Department dept = entityManager.find(Department.class, id);
        entityManager.remove(dept);
    }

    @Override
    @Transactional
    public void update(Department department) {
        entityManager.merge(department);
    }

    @Override
    public List<Department> findAll() {
        TypedQuery<Department> query = entityManager.createQuery("from Department", Department.class);
        return query.getResultList();
    }
}
