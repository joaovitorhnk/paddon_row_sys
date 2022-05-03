package com.paddon.rowsys.services.impl;
import com.paddon.rowsys.domain.dto.UserDTO;
import com.paddon.rowsys.domain.mapper.UserMapper;
import com.paddon.rowsys.domain.model.UserModal;
import com.paddon.rowsys.repositories.UserRepository;
import com.paddon.rowsys.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO saveUser(UserDTO user) {
        // TODO save new User
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            UserModal userModal = this.userRepository.save(this.userMapper.toModel(user));
            log.info("User saving in the DataBase {}", userModal);
            return this.userMapper.toDto(userModal);
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public List<UserDTO> findAllUsers() {
        // TODO search all users
        List<UserModal> response = this.userRepository.findAll();
        List<UserDTO> responseDto = new ArrayList<UserDTO>();
        for(UserModal user : response) {
            responseDto.add(this.userMapper.toDto(user));
        }
        return responseDto;
    }

    @Override
    public UserDTO findByUsername(String username) {
        // TODO search by id of the one user
        UserModal responseUser = this.userRepository.findByUsername(username).get();
        return this.userMapper.toDto(responseUser);
    }

}
