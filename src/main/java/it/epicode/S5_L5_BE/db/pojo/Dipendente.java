package it.epicode.S5_L5_BE.db.pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "dipendenti")
public class Dipendente {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;

    private String nome;

    private String cognome;

    private String email;

}
