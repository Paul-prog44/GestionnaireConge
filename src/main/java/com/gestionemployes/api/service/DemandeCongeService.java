package com.gestionemployes.api.service;

import com.gestionemployes.api.model.DemandeConge;
import com.gestionemployes.api.model.Employee;
import com.gestionemployes.api.model.Periode;
import com.gestionemployes.api.repository.DemandeCongeRepository;
import com.gestionemployes.api.repository.EmployeeRepository;
import com.gestionemployes.api.repository.PeriodeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@Service
public class DemandeCongeService {

    @Autowired
    private DemandeCongeRepository demandeCongeRepository;

    @Autowired
    private PeriodeRepository periodeRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

     public Optional<DemandeConge> getDemandeConge(final Long id) {
         return demandeCongeRepository.findById(id);
     }

     public Iterable<DemandeConge> getDemandeConges() {
         return demandeCongeRepository.findAll();
     }

     public void deleteDemandeConge(final Long id) {
         demandeCongeRepository.deleteById(id);
     }

     public DemandeConge saveDemandeConge(Long employeeId, Long periodeId) {
         Employee employe = employeeRepository.findById(employeeId)
                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employé non trouvé"));

         Periode periode = periodeRepository.findById(periodeId)
                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Période non trouvée"));

         DemandeConge demandeConge = new DemandeConge();
         demandeConge.setEmploye(employe);
         demandeConge.setPeriode(periode);
         demandeConge.setDateDemande(LocalDateTime.now());
         System.out.print(demandeConge);

         return demandeCongeRepository.save(demandeConge);
     }
}
