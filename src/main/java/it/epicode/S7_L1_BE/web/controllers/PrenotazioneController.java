package it.epicode.S7_L1_BE.web.controllers;

import it.epicode.S7_L1_BE.db.pojo.Prenotazione;
import it.epicode.S7_L1_BE.db.serv.PrenotazioneServ;
import it.epicode.S7_L1_BE.web.dto.PrenotazioneRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {

    @Autowired
    PrenotazioneServ prs;

    @GetMapping
    public ResponseEntity<List<Prenotazione>> findAll (){
        return ResponseEntity.ok( prs.findAll());
    }

    @PostMapping
    public ResponseEntity<Prenotazione> savePrenotazione (@RequestBody PrenotazioneRequest newP){
        return ResponseEntity.status(HttpStatus.CREATED).body(prs.save(newP));
    }
}
