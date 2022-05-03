package com.paddon.rowsys.controller;

import com.paddon.rowsys.domain.dto.UserDTO;
import com.paddon.rowsys.domain.mapper.UserMapper;
import com.paddon.rowsys.domain.model.UserModal;
import com.paddon.rowsys.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> findAllUser() {
        List<UserDTO> users = this.userService.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{username}")
    public UserDTO findUserByUsername(@PathVariable String username) {
        return this.userService.findByUsername(username);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/create").toUriString());
        UserDTO userSave = this.userService.saveUser(userDTO);
        return  ResponseEntity.created(uri).body(userSave);
    }

}
