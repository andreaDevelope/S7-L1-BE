package it.epicode.S7_L1_BE.db.repo;

import it.epicode.S7_L1_BE.db.pojo.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepo extends JpaRepository<Dipendente, Long> {
}
