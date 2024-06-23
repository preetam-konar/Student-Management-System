package com.konar.studentmanagementsystem.dao.studentdao;

import com.konar.studentmanagementsystem.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    private EntityManager entityManager;

    @Autowired
    StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student findByRegister(String rn) {
        TypedQuery<Student> query = entityManager.createQuery("from Student where registerNumber=:rn",
                Student.class);
        query.setParameter("rn", rn);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void deleteByRegister(String rn) {
        entityManager.createQuery("Delete from Student where registerNumber=:rn")
                .setParameter("rn", rn)
                .executeUpdate();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Student tempStudent = entityManager.find(Student.class, id);
        entityManager.remove(tempStudent);
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("from Student", Student.class);
        return query.getResultList();
    }
}
