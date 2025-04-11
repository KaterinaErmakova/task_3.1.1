package org.example.springbootapp.service;




import org.example.springbootapp.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
