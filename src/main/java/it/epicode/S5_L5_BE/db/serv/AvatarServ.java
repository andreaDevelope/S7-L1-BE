package it.epicode.S5_L5_BE.db.serv;

import it.epicode.S5_L5_BE.db.pojo.Avatar;
import it.epicode.S5_L5_BE.db.pojo.Dipendente;
import it.epicode.S5_L5_BE.db.repo.AvatarRepo;
import it.epicode.S5_L5_BE.db.repo.DipendenteRepo;
import it.epicode.S5_L5_BE.exceptions.AlreadyExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvatarServ {

    @Autowired
    private AvatarRepo avatarRepo;

    @Autowired
    private DipendenteRepo dipendenteRepo;

    public Avatar save(Avatar avatar, Long dipendenteId) {
        Dipendente dipendente = dipendenteRepo.findById(dipendenteId)
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato con ID: " + dipendenteId));

        Avatar existingAvatar = avatarRepo.findByDipendenteId(dipendenteId);
        if (existingAvatar != null) {
            throw new AlreadyExistsException("Il Dipendente con ID " + dipendenteId + " ha già un avatar associato.");
        }

        avatar.setDipendente(dipendente);

        return avatarRepo.save(avatar);
    }

}
