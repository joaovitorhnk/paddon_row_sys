package com.paddon.rowsys.services.impl;

import com.paddon.rowsys.domain.model.User;
import com.paddon.rowsys.repositories.UserRepository;
import com.paddon.rowsys.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        // TODO save new User
        this.userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        // TODO search all users
        return this.userRepository.findAll();
    }

    @Override
    public User findByUsername(User user) {
        // TODO search by id of the one user
       return null;

    }



    @Override
    public void deleteUser(User user) {
        // TODO delete User byId
    }

    @Override
    public User findByUser(User user) {
        return this.userRepository.findById(user.getId()).get();
    }

    @Override
    public User updateUser(Long id, User user) {
        // TODO search user by id and update with new users credentials
        return null;
    }
}
