package com.konar.studentmanagementsystem.dao.securitydao;

import com.konar.studentmanagementsystem.entity.security.Role;
import com.konar.studentmanagementsystem.entity.security.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    @Autowired
    UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void remove(User user) {
        entityManager.remove(user.getRole());
        entityManager.remove(user);
    }

    @Override
    @Transactional
    public void removeByUserId(String userId) {
        User tempUser = entityManager.find(User.class, userId);
        Role role = tempUser.getRole();
        entityManager.remove(role);
        entityManager.remove(tempUser);
    }

    @Override
    public User findByUserId(String userId) {
        return entityManager.find(User.class, userId);
    }

    @Override
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }
}
