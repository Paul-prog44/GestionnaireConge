package com.gestionemployes.api.controller;

import com.gestionemployes.api.dto.DemandeCongeRequest;
import com.gestionemployes.api.model.DemandeConge;
import com.gestionemployes.api.service.DemandeCongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DemandeCongeController {

    @Autowired
    private DemandeCongeService demandeCongeService;

    @GetMapping("/demandeConges")
    public Iterable<DemandeConge> getDemandeConges() {
        return demandeCongeService.getDemandeConges();
    }

    @GetMapping("/demandeConges/{id}")
    public DemandeConge getDemandeConge(@PathVariable("id") Long id) {
        return demandeCongeService.getDemandeConge(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Demande de congé non trouvée"));
    }

    @DeleteMapping("/demandeConges/{id}")
    public ResponseEntity deleteDemandeConge(@PathVariable("id") Long id) {
        demandeCongeService.deleteDemandeConge(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/demandeConges")
    public ResponseEntity<DemandeConge> createDemandeConge(@RequestBody DemandeCongeRequest demandeCongeRequest ) {
        Long employeeId = demandeCongeRequest.getEmployeeId();
        Long periodeId = demandeCongeRequest.getPeriodeId();

        DemandeConge demandeConge = demandeCongeService.saveDemandeConge(employeeId, periodeId);
        return ResponseEntity.status(HttpStatus.CREATED).body(demandeConge);
    }
}
