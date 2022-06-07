package com.paddon.rowsys.controller;

import com.paddon.rowsys.domain.dto.UserDTO;
import com.paddon.rowsys.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserDTO>> findAllUser() {
        List<UserDTO> users = this.userService.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserDTO findUserByUsername(@PathVariable String username) {
        return this.userService.findByUsername(username);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        UserDTO userSave = this.userService.saveUser(userDTO);
        return  ResponseEntity.ok().body(userSave);
    }

    @DeleteMapping("{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable String username) {
        UserDTO userDTO = this.userService.deleteUser(username);
        return ResponseEntity.ok().body(userDTO);
    }


}
