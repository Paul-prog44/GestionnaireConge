package com.gestionemployes.api.service;

import com.gestionemployes.api.model.DemandeConge;
import com.gestionemployes.api.repository.DemandeCongeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class DemandeCongeService {

     @Autowired
    private DemandeCongeRepository demandeCongeRepository;

     public Optional<DemandeConge> getDemandeConge(final Long id) {
         return demandeCongeRepository.findById(id);
     }

     public Iterable<DemandeConge> getDemandeConges() {
         return demandeCongeRepository.findAll();
     }

     public void deleteDemandeConge(final Long id) {
         demandeCongeRepository.deleteById(id);
     }

     public DemandeConge saveDemandeConge(DemandeConge demandeConge) {
         DemandeConge savedDemandeConge = demandeCongeRepository.save(demandeConge);
         return demandeConge;
     }
}
