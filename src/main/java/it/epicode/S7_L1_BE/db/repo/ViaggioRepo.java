package it.epicode.S7_L1_BE.db.repo;

import it.epicode.S7_L1_BE.db.pojo.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViaggioRepo extends JpaRepository<Viaggio, Long> {
}
