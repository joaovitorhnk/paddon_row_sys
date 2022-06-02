package com.paddon.rowsys.config.jwt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtResponse {

    private String accessToken;
    private String tokenType = "Bearer";
    private String role;

    public JwtResponse (String accessToken, String role) {
        this.accessToken = accessToken;
        this.role = role;
    }

}