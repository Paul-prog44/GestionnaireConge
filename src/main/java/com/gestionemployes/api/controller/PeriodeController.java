package com.gestionemployes.api.controller;

import com.gestionemployes.api.model.Periode;
import com.gestionemployes.api.service.PeriodeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PeriodeController {

    @Autowired
    private PeriodeService periodeService;

    @GetMapping("/periodes")
    public Iterable<Periode> getPeriodes() {
        return periodeService.getPeriodes();
    }

    @GetMapping("/periodes/{id}")
    public Periode getPeriode(@PathVariable("id") Long id) {
        return periodeService.getPeriode(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Periode non trouvé"));
    }

    @DeleteMapping("/periodes/{id}")
    public ResponseEntity deletePeriode(@PathVariable("id") Long id) {
        periodeService.deletePeriode(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/periodes")
    public ResponseEntity<Periode> createPeriode(@RequestBody Periode newPeriode) {
        Periode periode = periodeService.savePeriode(newPeriode);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPeriode);
    }

}
