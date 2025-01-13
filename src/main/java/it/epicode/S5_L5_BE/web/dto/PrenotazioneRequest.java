package it.epicode.S5_L5_BE.web.dto;

import it.epicode.S5_L5_BE.db.pojo.Dipendente;
import it.epicode.S5_L5_BE.db.pojo.Viaggio;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PrenotazioneRequest {
    @FutureOrPresent(message = "il campo data prenotazione non può essere una data passata")
    @NotNull(message = "il campo data prenotazione è obbligatorio")
    private LocalDate dataPrenotazione;
    private String note;//da traccia è facoltativo
    @NotNull(message = "il campo dipendente id è obbligatorio")
    private Long dipendenteId;
    @NotNull(message = "il campo viaggio id è obbligatorio")
    private Long viaggioId;
}
