package it.epicode.S7_L1_BE.web.security.auth;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private String email;

}
