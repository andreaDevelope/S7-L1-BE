package it.epicode.S5_L5_BE.db.repo;

import it.epicode.S5_L5_BE.db.pojo.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneRepo extends JpaRepository<Prenotazione, Long> {
}
