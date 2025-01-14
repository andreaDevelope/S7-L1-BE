package it.epicode.S7_L1_BE.web.dto;

import it.epicode.S7_L1_BE.enums.Stato;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ViaggioStatoRequest {
    @NotNull(message = "il campo stato è obbligatorio")
    private Stato stato;
}
