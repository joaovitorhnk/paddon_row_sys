package com.paddon.rowsys.domain.exceptions;

import com.paddon.rowsys.domain.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserExceptions extends RuntimeException {}
