package it.epicode.S5_L5_BE.db.repo;

import it.epicode.S5_L5_BE.db.pojo.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarRepo extends JpaRepository<Avatar, Long> {
    Avatar findByDipendenteId(Long dipendenteId);
}
