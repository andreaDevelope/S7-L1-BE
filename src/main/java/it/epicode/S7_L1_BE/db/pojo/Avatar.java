package it.epicode.S7_L1_BE.db.pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "avatars")
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imageUrl;

    @OneToOne
    Dipendente dipendente;
}
