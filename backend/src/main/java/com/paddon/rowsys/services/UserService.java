package com.paddon.rowsys.services;

import com.paddon.rowsys.domain.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);
    List<User> findAllUsers();
    User findByUsername(User user);
    void deleteUser(User user);

    User findByUser(User user);
    User updateUser(Long id, User user);

}
