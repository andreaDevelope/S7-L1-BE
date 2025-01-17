package it.epicode.S7_L1_BE.web.controllers;

import it.epicode.S7_L1_BE.db.pojo.Dipendente;
import it.epicode.S7_L1_BE.db.serv.DipendenteServ;
import it.epicode.S7_L1_BE.web.dto.DipendenteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dipendenti")
public class DipendenteController {
    @Autowired
    DipendenteServ ds;

    @GetMapping
    public ResponseEntity<List<Dipendente>> getAll(){
        return ResponseEntity.ok(ds.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dipendente> getDipedeteById(@PathVariable Long id){
        return ResponseEntity.ok(ds.findById(id));
    }

    @PostMapping
    public ResponseEntity<Dipendente> saveDipendente(@RequestBody DipendenteRequest newD){
        return ResponseEntity.status(HttpStatus.CREATED).body(ds.save(newD));
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/{id}")
    public ResponseEntity<Dipendente> updateDipendente(@RequestBody DipendenteRequest newD, @PathVariable Long id){
        return ResponseEntity.ok(ds.update(newD, id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Dipendente> deleteDipendente(@PathVariable Long id){
        return ResponseEntity.ok(ds.delete(id));
    }
}
