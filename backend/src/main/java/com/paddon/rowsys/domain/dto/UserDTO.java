package com.paddon.rowsys.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.paddon.rowsys.utils.enums.Role;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter @Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    @NotNull
    private String username;
    @NotNull
    private String password;
    private boolean isEnabled;
    private Role role;

}
