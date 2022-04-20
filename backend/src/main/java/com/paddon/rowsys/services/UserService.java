package com.paddon.rowsys.services;

import com.paddon.rowsys.domain.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);
    List<User> findAllUsers();
    User findByUser(User user);
    void deleteUser(User user);

    User updateUser(Long id, User user);

}
