package it.epicode.S5_L5_BE.db.repo;

import it.epicode.S5_L5_BE.db.pojo.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViaggioRepo extends JpaRepository<Viaggio, Long> {
}
