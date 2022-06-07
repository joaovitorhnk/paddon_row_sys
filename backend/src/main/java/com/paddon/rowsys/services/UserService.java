package com.paddon.rowsys.services;

import com.paddon.rowsys.domain.dto.UserDTO;
import com.paddon.rowsys.domain.model.UserModal;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO saveUser(UserDTO user);
    List<UserDTO> findAllUsers();
    UserDTO findByUsername(String username);

    UserDTO deleteUser(String username);
}
