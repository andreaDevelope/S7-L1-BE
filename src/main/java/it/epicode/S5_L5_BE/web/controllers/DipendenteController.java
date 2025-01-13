package it.epicode.S5_L5_BE.web.controllers;

import it.epicode.S5_L5_BE.db.pojo.Dipendente;
import it.epicode.S5_L5_BE.db.serv.DipendenteServ;
import it.epicode.S5_L5_BE.web.dto.DipendenteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/{id}")
    public ResponseEntity<Dipendente> updateDipendente(@RequestBody DipendenteRequest newD, @PathVariable Long id){
        return ResponseEntity.ok(ds.update(newD, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Dipendente> deleteDipendente(@PathVariable Long id){
        return ResponseEntity.ok(ds.delete(id));
    }
}
