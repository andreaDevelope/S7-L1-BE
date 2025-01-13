package it.epicode.S5_L5_BE.db.serv;

import it.epicode.S5_L5_BE.db.pojo.Dipendente;
import it.epicode.S5_L5_BE.db.pojo.Prenotazione;
import it.epicode.S5_L5_BE.db.pojo.Viaggio;
import it.epicode.S5_L5_BE.db.repo.DipendenteRepo;
import it.epicode.S5_L5_BE.db.repo.PrenotazioneRepo;
import it.epicode.S5_L5_BE.db.repo.ViaggioRepo;
import it.epicode.S5_L5_BE.exceptions.AlreadyExistsException;
import it.epicode.S5_L5_BE.exceptions.UploadException;
import it.epicode.S5_L5_BE.web.dto.PrenotazioneRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class PrenotazioneServ {

    @Autowired
    private PrenotazioneRepo pr;

    @Autowired
    private DipendenteRepo dipendenteRepo;

    @Autowired
    private ViaggioRepo viaggioRepo;

    public List<Prenotazione> findAll() {
        return pr.findAll();
    }

    public Prenotazione save(@Valid PrenotazioneRequest newP) {
        Prenotazione p = new Prenotazione();

        Dipendente dipendente = dipendenteRepo.findById(newP.getDipendenteId())
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato con ID: " + newP.getDipendenteId()));

        Viaggio viaggio = viaggioRepo.findById(newP.getViaggioId())
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato con ID: " + newP.getViaggioId()));

        BeanUtils.copyProperties(newP, p);
        p.setDipendente(dipendente);
        p.setViaggio(viaggio);

        try {
            return pr.save(p);
        } catch (DataIntegrityViolationException ex) {
            throw new AlreadyExistsException("La prenotazione è duplicata: controlla i dati univoci (dipendente e data).");
        } catch (Exception ex) {
            throw new UploadException("Errore generico durante il salvataggio della prenotazione: " + ex.getMessage());
        }
    }
}
