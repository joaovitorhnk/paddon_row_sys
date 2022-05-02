package com.paddon.rowsys;

import com.paddon.rowsys.domain.model.User;
import com.paddon.rowsys.repositories.UserRepository;
import com.paddon.rowsys.utils.enums.Role;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class RowsysApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(RowsysApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String...args) throws Exception {
		this.userRepository.save(new User(
				null,
				"admin",
				"admin",
				LocalDateTime.now(),
				LocalDateTime.now(),
				Role.ADMIN_SYSTEM
		));
	}
}
