package it.epicode.S5_L5_BE.web.dto;

import it.epicode.S5_L5_BE.enums.Stato;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ViaggioRequest {

    @NotBlank(message = "il campo destinazione è obbligatorio")
    private String destinazione;

    @FutureOrPresent(message = "il campo data non può essere una data passata")
    @NotNull(message = "il campo data è obbligatorio")
    private LocalDate data;

    @NotNull(message = "il campo stato è obbligatorio")
    private Stato stato;
}
