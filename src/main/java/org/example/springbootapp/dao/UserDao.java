package org.example.springbootapp.dao;

import org.example.springbootapp.models.User;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public interface UserDao {
    List<User> getAllUsers();
    User getUserById(int id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
