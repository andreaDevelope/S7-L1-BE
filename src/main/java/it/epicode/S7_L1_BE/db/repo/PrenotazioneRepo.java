package it.epicode.S7_L1_BE.db.repo;

import it.epicode.S7_L1_BE.db.pojo.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneRepo extends JpaRepository<Prenotazione, Long> {
}
