package it.epicode.S5_L5_BE.db.serv;


import it.epicode.S5_L5_BE.db.pojo.Viaggio;
import it.epicode.S5_L5_BE.db.repo.ViaggioRepo;

import it.epicode.S5_L5_BE.exceptions.AlreadyExistsException;
import it.epicode.S5_L5_BE.exceptions.UploadException;
import it.epicode.S5_L5_BE.web.dto.ViaggioRequest;
import it.epicode.S5_L5_BE.web.dto.ViaggioStatoRequest;
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
    public class ViaggioServ {
    @Autowired
    ViaggioRepo vr;

    public List<Viaggio> findAll() {
        return vr.findAll();
    }

    public Viaggio findById(Long id) {
        if (!vr.existsById(id)) {
            throw new EntityNotFoundException("Viaggio con ID " + id + " non trovato!");
        }
        return vr.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Viaggio con ID " + id + " non trovato!"));
    }

    public Viaggio saveViaggio(@Valid ViaggioRequest newV) {
        Viaggio v = new Viaggio();
        BeanUtils.copyProperties(newV, v);

        try {
            return vr.save(v);
        } catch (DataIntegrityViolationException ex) {
            throw new AlreadyExistsException("Viaggio duplicato: destinazione " +
                    newV.getDestinazione() + ", data " +
                    newV.getData());
        } catch (Exception ex) {
            throw new UploadException("Errore durante il salvataggio del viaggio: " + ex.getMessage());
        }
    }

    public Viaggio update(@Valid ViaggioRequest newV, Long id) {
        if (!vr.existsById(id)) {
            throw new EntityNotFoundException("Viaggio con ID " + id + " non trovato!");
        }

        Viaggio v = vr.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Viaggio con ID " + id + " non trovato!"));

        BeanUtils.copyProperties(newV, v);

        try {
            return vr.save(v);
        } catch (DataIntegrityViolationException ex) {
            throw new AlreadyExistsException("Viaggio duplicato durante l'aggiornamento: destinazione " +
                    newV.getDestinazione() + ", data " +
                    newV.getData());
        }
    }

    public Viaggio updateStato(Long id, @Valid ViaggioStatoRequest newStato) {
        if (!vr.existsById(id)) {
            throw new EntityNotFoundException("Viaggio con ID " + id + " non trovato!");
        }

        Viaggio v = vr.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Viaggio con ID " + id + " non trovato!"));

        BeanUtils.copyProperties(newStato, v);

        try {
            return vr.save(v);
        } catch (Exception ex) {
            throw new UploadException("Errore durante l'aggiornamento dello stato: " + ex.getMessage());
        }
    }

    public Viaggio delete(Long id) {
        if (!vr.existsById(id)) {
            throw new EntityNotFoundException("Viaggio con ID " + id + " non trovato!");
        }

        Viaggio v = vr.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Viaggio con ID " + id + " non trovato!"));

        try {
            vr.delete(v);
            return v;
        } catch (Exception ex) {
            throw new UploadException("Errore durante l'eliminazione del viaggio: " + ex.getMessage());
        }
    }


}
