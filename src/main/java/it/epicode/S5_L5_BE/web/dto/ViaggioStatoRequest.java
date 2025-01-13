package it.epicode.S5_L5_BE.web.dto;

import it.epicode.S5_L5_BE.enums.Stato;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ViaggioStatoRequest {
    @NotNull(message = "il campo stato è obbligatorio")
    private Stato stato;
}
