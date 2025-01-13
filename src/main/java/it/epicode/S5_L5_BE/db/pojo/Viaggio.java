package it.epicode.S5_L5_BE.db.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.epicode.S5_L5_BE.enums.Stato;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "viaggi")
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String destinazione;

    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    @JsonIgnore
    @OneToMany(mappedBy = "viaggio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prenotazione> prenotazioni;

}
