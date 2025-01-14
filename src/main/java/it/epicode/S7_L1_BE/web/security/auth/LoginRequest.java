package it.epicode.S7_L1_BE.web.security.auth;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
