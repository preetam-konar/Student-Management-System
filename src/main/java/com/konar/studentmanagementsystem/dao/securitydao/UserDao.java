package com.konar.studentmanagementsystem.dao.securitydao;

import com.konar.studentmanagementsystem.entity.security.Role;
import com.konar.studentmanagementsystem.entity.security.User;

public interface UserDao {

    void add(User user, Role role);

    void remove(User user);

    void removeByUserId(String userId);

    User findByUserId(String userId);

    void update(User user);

}
