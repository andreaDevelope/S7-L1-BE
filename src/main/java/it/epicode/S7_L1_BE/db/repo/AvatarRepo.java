package it.epicode.S7_L1_BE.db.repo;

import it.epicode.S7_L1_BE.db.pojo.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarRepo extends JpaRepository<Avatar, Long> {
    Avatar findByDipendenteId(Long dipendenteId);
}
