package it.epicode.S5_L5_BE.web.security.auth;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
