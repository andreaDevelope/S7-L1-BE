package it.epicode.S5_L5_BE.db.pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "prenotazioni", uniqueConstraints = {
        //rende univoca la relazione
        @UniqueConstraint(columnNames = {"dipendente_id", "dataPrenotazione"})
})
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDate dataPrenotazione;

    private String note;

    @ManyToOne
    private Dipendente dipendente;

    @ManyToOne
    private Viaggio viaggio;
}
