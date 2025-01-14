package it.epicode.S7_L1_BE.db.serv;

import it.epicode.S7_L1_BE.db.pojo.Dipendente;
import it.epicode.S7_L1_BE.db.repo.DipendenteRepo;
import it.epicode.S7_L1_BE.exceptions.AlreadyExistsException;
import it.epicode.S7_L1_BE.exceptions.UploadException;
import it.epicode.S7_L1_BE.web.dto.DipendenteRequest;
import it.epicode.S7_L1_BE.web.security.auth.AppUser;
import it.epicode.S7_L1_BE.web.security.auth.AppUserRepository;
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
public class DipendenteServ {

    @Autowired
    private DipendenteRepo dr;

    @Autowired
    AppUserRepository ur;

    public List<Dipendente> findAll() {
        return dr.findAll();
    }

    public Dipendente findById(Long id) {
        if (!dr.existsById(id)) {
            throw new EntityNotFoundException("Dipendente con ID " + id + " non trovato!");
        }
        return dr.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Dipendente con ID " + id + " non trovato!"));
    }

    public Dipendente save(@Valid DipendenteRequest newD) {
        Dipendente d = new Dipendente();
        BeanUtils.copyProperties(newD, d);

        try {
            return dr.save(d);
        } catch (DataIntegrityViolationException ex) {
            throw new AlreadyExistsException("Dipendente duplicato: controlla le chiavi univoche!");
        } catch (Exception ex) {
            throw new UploadException("Errore durante il salvataggio del dipendente: " + ex.getMessage());
        }
    }

    public Dipendente create(Dipendente d){
        return dr.save(d);
    }

    public Dipendente update(@Valid DipendenteRequest newD, Long id) {
        if (!dr.existsById(id)) {
            throw new EntityNotFoundException("Dipendente con ID " + id + " non trovato!");
        }

        Dipendente d = dr.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Dipendente con ID " + id + " non trovato!"));

        BeanUtils.copyProperties(newD, d);

        try {
            return dr.save(d);
        } catch (DataIntegrityViolationException ex) {
            throw new AlreadyExistsException("Errore durante l'aggiornamento: dati duplicati rilevati!");
        } catch (Exception ex) {
            throw new UploadException("Errore durante l'aggiornamento del dipendente: " + ex.getMessage());
        }
    }

    public Dipendente delete(Long id) {
        if (!dr.existsById(id)) {
            throw new EntityNotFoundException("Dipendente con ID " + id + " non trovato!");
        }

        Dipendente d = dr.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Dipendente con ID " + id + " non trovato!"));

        try {
            dr.delete(d);
            return d;
        } catch (Exception ex) {
            throw new UploadException("Errore durante l'eliminazione del dipendente: " + ex.getMessage());
        }
    }

    public List<String> findByUtente(String utente) {
        // cerco nel db lo user tramite user name

        AppUser appUser = ur.findByUsername(utente)
                .orElseThrow(() -> new IllegalArgumentException("Utente non trovato"));

        return List.of("Il signore degli anelli", "Il trono di spade", "Il nome della rosa");
    }
}