package it.epicode.S5_L5_BE.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DipendenteRequest {
    @NotBlank(message = "il campo username è obbligatorio")
    private String username;

    @NotBlank(message = "il campo nome è obbligatorio")
    private String nome;

    @NotBlank(message = "il campo cognome è obbligatorio")
    private String cognome;

    @NotBlank(message = "il campo e-mail è obbligatorio")
    @Email(message = "inserire una e-mail valid")
    private String email;
}
