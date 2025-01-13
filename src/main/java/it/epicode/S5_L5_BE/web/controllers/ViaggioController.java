package it.epicode.S5_L5_BE.web.controllers;

import it.epicode.S5_L5_BE.db.pojo.Viaggio;
import it.epicode.S5_L5_BE.db.serv.ViaggioServ;
import it.epicode.S5_L5_BE.web.dto.ViaggioRequest;
import it.epicode.S5_L5_BE.web.dto.ViaggioStatoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viaggi")
public class ViaggioController {

    @Autowired
    ViaggioServ vs;

    @GetMapping
    public ResponseEntity<List<Viaggio>> getAll(){
        return ResponseEntity.ok(vs.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viaggio> getViaggioById(@PathVariable Long id){
        return ResponseEntity.ok(vs.findById(id));
    }

    @PostMapping
    public ResponseEntity<Viaggio> saveViaggio(@RequestBody ViaggioRequest newV){
        return ResponseEntity.status(HttpStatus.CREATED).body(vs.saveViaggio(newV));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Viaggio> updateViaggio(@RequestBody ViaggioRequest newD, @PathVariable Long id){
        return ResponseEntity.ok(vs.update(newD, id));
    }

    @PutMapping("/updateStato/{id}")
    public ResponseEntity<Viaggio> updateViaggioStato(@RequestBody ViaggioStatoRequest newStato, @PathVariable Long id){
        return ResponseEntity.ok(vs.updateStato(id, newStato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Viaggio> deleteViaggio(@PathVariable Long id){
        return ResponseEntity.ok(vs.delete(id));
    }

}
