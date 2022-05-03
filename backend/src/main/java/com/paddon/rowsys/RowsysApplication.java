package com.paddon.rowsys;

import com.paddon.rowsys.domain.dto.UserDTO;
import com.paddon.rowsys.domain.model.UserModal;
import com.paddon.rowsys.services.UserService;
import com.paddon.rowsys.services.impl.UserServiceImpl;
import com.paddon.rowsys.utils.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class RowsysApplication implements CommandLineRunner {

	@Autowired
	private UserServiceImpl userService;

	public static void main(String[] args) {
		SpringApplication.run(RowsysApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		UserDTO userDTO = new UserDTO(
				"admin6",
				"admin6",
				true,
				Role.USER
		);

		userService.saveUser(userDTO);
	}
}
