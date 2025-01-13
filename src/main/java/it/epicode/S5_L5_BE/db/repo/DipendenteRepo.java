package it.epicode.S5_L5_BE.db.repo;

import it.epicode.S5_L5_BE.db.pojo.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepo extends JpaRepository<Dipendente, Long> {
}
